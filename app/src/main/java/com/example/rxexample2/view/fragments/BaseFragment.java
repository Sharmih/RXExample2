package com.example.rxexample2.view.fragments;

import androidx.fragment.app.Fragment;

import com.example.rxexample2.presenter.BasePresenter;

public abstract class BaseFragment extends Fragment {

    protected abstract BasePresenter getPresenter();

    @Override
    public void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onStop();
        }
    }
}
