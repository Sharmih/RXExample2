package com.example.rxexample2.view;

import com.example.rxexample2.model.data.Repo;

import java.util.List;

public interface IView {

    void showData(List<Repo> list);

    void showError(String error);

    void showEmptyList();

    String getUserName();
}
