package com.example.fragmentview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;


public class GoogleLoginActivity extends AppCompatActivity{

    SignInButton btn_google_signin;
    GoogleSignInClient mGoogleSignInClient;
    int KL_SIGN_IN = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_login);
        onStart();
        btn_google_signin = findViewById(R.id.btn_google_signin);
        btn_google_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_google_signin:
                        signIn();
                        break;
                }
            }
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

    }

        private void signIn() {
            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
            startActivityForResult(signInIntent, KL_SIGN_IN);
        }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == KL_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            if(completedTask.isSuccessful()){
                //google fetch the login email address and verifiy the domain
                GoogleSignInAccount account = completedTask.getResult(ApiException.class);
                String email = account.getEmail();
                String[] split = email.split("@");
                String domain = split[1]; //This Will Give You The Domain After '@'
                if(domain.equals("knowledgelens.com"))
                {
                    Intent intent = new Intent(GoogleLoginActivity.this, DashboardActivity.class);
                    startActivity(intent);
                }
                else
                {

                    //google doesnt sign in if the domain doesnt match
                    Toast.makeText(GoogleLoginActivity.this, "User with this email doesn't exist", Toast.LENGTH_LONG).show();
                    mGoogleSignInClient.signOut();
                }
            }

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("error", "signInResult:failed code=" + e.getStatusCode());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount alreadyloggedAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (alreadyloggedAccount != null) {
            Toast.makeText(this, "Already Logged In", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(GoogleLoginActivity.this, DashboardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else {

        }
    }
}