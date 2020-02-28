package com.example.fragmentview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import static android.content.Context.MODE_PRIVATE;

public class Utils {

        public static void SetFragment(Fragment fragment, boolean removeStack, FragmentActivity activity, int mContainer, Bundle args) {

            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            FragmentTransaction ftTransaction = fragmentManager.beginTransaction();
            fragment.setArguments(args);
            if (removeStack) {
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                ftTransaction.replace(mContainer, fragment);
            }
            else {
                ftTransaction.replace(mContainer, fragment);
                ftTransaction.addToBackStack(null);
            }
            ftTransaction.commit();
        }

        //AES Encryption
        public static String encrypt(String key, String initVector, String value) {
            try {
                IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
                SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
                cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

                byte[] encrypted = cipher.doFinal(value.getBytes());

                String base64string = Base64.encodeToString(encrypted,Base64.DEFAULT);
                Log.e("base64string",base64string);

                return base64string;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return null;
        }


        //MD5 Encryption
        public static String CreateMD5(String ps){
            String testString=ps;
            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            byte[] messageDigest = md.digest(testString.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            Log.e("hashtext",hashtext);
            return hashtext;
        }

        public static String getprefs(Context context, String name, String defaultv){
            String s = "";
            sharedpreferences = context.getSharedPreferences(MY_PREFERENCES, MODE_PRIVATE);
            s = context.getSharedPreferences(MY_PREFERENCES, 0).getString(name, defaultv);
            return s;
        }
        public static void editprefs(Context context,String name,String value){
            sharedpreferences = context.getSharedPreferences(MY_PREFERENCES, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(name, value);
            editor.apply();
        }
        public static final String MY_PREFERENCES = "MyPrefs";
        static SharedPreferences sharedpreferences;
    }


