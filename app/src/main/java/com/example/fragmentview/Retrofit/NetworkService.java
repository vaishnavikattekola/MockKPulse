package com.example.fragmentview.Retrofit;

import android.content.Context;
import android.util.Log;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetworkService {


    Context context;

    public NetworkService(Context context) {
        this.context = context;
    }

    ApiInterface apiInterface;

    public static ApiInterface getApiService(Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(60 * 1000, TimeUnit.SECONDS).readTimeout(60 * 1000, TimeUnit.SECONDS).writeTimeout(60 * 1000, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        Request original = chain.request();
                        Request.Builder requestBuilder = original.newBuilder()
                                .method(original.method(), original.body());
                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                }).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WebRequest.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                .client(okHttpClient)
                .build();

        Log.e("BAse url",WebRequest.BASE_URL.toString());
        return retrofit.create(ApiInterface.class);
        //
    }
}

