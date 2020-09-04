package com.example.rxexample2.view.fragments;

import com.example.rxexample2.presenter.vo.Repository;

import java.util.List;

public interface RepoListView extends View {

    void showRepoList(List<Repository> vo);

    void startRepoInfoFragment(Repository vo);

    void showEmptyList();

    String getUserName();
}
