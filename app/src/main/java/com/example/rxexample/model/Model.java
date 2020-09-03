package com.example.rxexample.model;

import com.example.rxexample.model.data.Repo;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface Model {

    Observable<List<Repo>> getRepoList(String name);
}
