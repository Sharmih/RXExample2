package com.example.rxexample.model.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiModule {

    private static final boolean ENABLE_AUTH = false;
    private static final String AUTH_64 = "***"; //your code here

    public static ApiInterface getApiInterface() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                        @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                            Request original = chain.request();

            Request.Builder requestBuilder = original.newBuilder()
                    .header("Authorization", "Basic " + AUTH_64)
                    .method(original.method(), original.body());

            Request request = requestBuilder.build();
            return chain.proceed(request);
        }}
                )
        .build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

        if (ENABLE_AUTH) builder.client(httpClient);
        ApiInterface apiInterface = builder.build().create(ApiInterface.class);
        return apiInterface;
}}
