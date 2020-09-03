package com.example.rxexample2.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.rxexample2.R;
import com.example.rxexample2.databinding.ActivityMainBinding;
import com.example.rxexample2.model.data.Repo;
import com.example.rxexample2.presenter.Presenter;
import com.example.rxexample2.presenter.RepoListPresenter;
import com.example.rxexample2.view.adapters.RecyclerViewAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {

    private RecyclerViewAdapter adapter;

    private Presenter presenter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        android.view.View view = binding.getRoot();
        setContentView(view);


        setSupportActionBar(binding.toolbar);

        presenter = new RepoListPresenter(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(llm);
        adapter = new RecyclerViewAdapter();
        binding.recyclerView.setAdapter(adapter);

        binding.button.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                presenter.onSearchButtonClick();
            }
        });
    }

    @Override
    public void showData(List<Repo> list) {
        adapter.setRepoList(list);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.onStop();
        }
    }

    private void makeToast(String text) {
        Snackbar.make(binding.toolbar, text, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showError(String error) {
        makeToast(error);
    }

    @Override
    public void showEmptyList() {
        makeToast(getString(R.string.empty_repo_list));
    }

    @Override
    public String getUserName() {
        return binding.editText.getText().toString();
    }
}