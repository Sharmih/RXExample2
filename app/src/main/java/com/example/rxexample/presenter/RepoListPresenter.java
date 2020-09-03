package com.example.rxexample.presenter;

import com.example.rxexample.model.Model;
import com.example.rxexample.model.ModelImpl;
import com.example.rxexample.model.data.Repo;
import com.example.rxexample.view.IView;

import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

public class RepoListPresenter implements Presenter {

    private Model model = new ModelImpl();

    private IView view;
    private Disposable disposable = Disposable.empty();

    public RepoListPresenter(IView view) {
        this.view = view;
    }

    @Override
    public void onSearchButtonClick() {

        if (!disposable.isDisposed()) {
            disposable.dispose();
        }

        disposable = model.getRepoList(view.getUserName())
                .subscribe((List<Repo> data) -> {
                    if (data != null && !data.isEmpty()) {
                        view.showData(data);
                        } else {
                        view.showEmptyList();
                        }
                }, throwable -> {
                    view.showError(throwable.getMessage());
                });
    }

    @Override
    public void onStop() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
