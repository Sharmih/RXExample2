package com.example.rxexample2.model.api;

import com.example.rxexample2.model.data.Repo;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    public static final String ENDPOINT = "https://api.github.com/";

    @GET("users/{user}/repos")
    Observable<List<Repo>> getRepositories(@Path("user") String user);
}
