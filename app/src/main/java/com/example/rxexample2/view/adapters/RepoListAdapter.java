package com.example.rxexample2.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.rxexample2.R;
import com.example.rxexample2.model.dto.RepositoryDTO;
import com.example.rxexample2.presenter.RepoListPresenter;
import com.example.rxexample2.presenter.vo.Repository;

import java.util.ArrayList;
import java.util.List;

public class RepoListAdapter extends BaseAdapter<Repository> {
    private RepoListPresenter presenter;


    public RepoListAdapter(List<Repository> list, RepoListPresenter presenter) {
        super(list);
        this.presenter = presenter;
    }

    @Override
    public void onBindViewHolder(BaseAdapter.ViewHolder viewHolder, int i) {
        Repository repo = list.get(i);
        viewHolder.text.setText(repo.getRepoName());
        viewHolder.text.setOnClickListener(v -> presenter.clickRepo(repo));
    }

    public void setRepoList(List<Repository> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
