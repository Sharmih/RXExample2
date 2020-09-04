package com.example.rxexample2.presenter;

import com.example.rxexample2.model.Model;
import com.example.rxexample2.model.ModelImpl;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public abstract class BasePresenter implements Presenter {

    protected Model dataRepository = new ModelImpl();
    private CompositeDisposable compositeSubscription = new CompositeDisposable();

    protected void addDisposable(Disposable disposable) {
        compositeSubscription.add(disposable);
    }

    @Override
    public void onStop() {
        compositeSubscription.clear();
    }

}
