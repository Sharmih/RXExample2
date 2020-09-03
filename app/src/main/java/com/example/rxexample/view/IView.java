package com.example.rxexample.view;

import com.example.rxexample.model.data.Repo;

import java.util.List;

public interface IView {

    void showData(List<Repo> list);

    void showError(String error);

    void showEmptyList();

    String getUserName();
}
