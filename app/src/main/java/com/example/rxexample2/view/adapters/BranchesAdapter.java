package com.example.rxexample2.view.adapters;

import android.widget.BaseAdapter;

import com.example.rxexample2.presenter.vo.Branch;

import java.util.List;

public class BranchesAdapter extends BaseAdapter<Branch> {

    public BranchesAdapter(List<Branch> list) {
        super(list);
    }

    @Override
    public void onBindViewHolder(BaseAdapter.ViewHolder holder, int position) {
        String text = list.get(position).getName();
        holder.text.setText(text);
    }
}
