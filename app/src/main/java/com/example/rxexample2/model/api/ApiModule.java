package com.example.rxexample2.model.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiModule {

    private static final boolean ENABLE_LOG = true;
    private static final boolean ENABLE_AUTH = false;
    private static final String AUTH_64 = "***"; //your code here
    private static final String BASE_URL = "https://api.github.com/";

    public static ApiInterface getApiInterface() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();

        if (ENABLE_LOG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.interceptors().add(interceptor);
        }

        if (ENABLE_AUTH) {
            builder.interceptors().add(chain -> {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("Authorization", "Basic " + AUTH_64)
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            });
        }

        OkHttpClient client = builder.build();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

        retrofitBuilder.client(client);
        ApiInterface apiInterface = retrofitBuilder.build().create(ApiInterface.class);
        return apiInterface;
}}
