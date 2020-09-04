package com.example.rxexample2.view.fragments;

import com.example.rxexample2.presenter.vo.Branch;
import com.example.rxexample2.presenter.vo.Contributor;

import java.util.List;

public interface RepoInfoView extends View {

    void showContributors(List<Contributor> contributors);

    void showBranches(List<Branch> branches);

}
