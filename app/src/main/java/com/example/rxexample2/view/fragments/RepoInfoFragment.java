package com.example.rxexample2.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxexample2.R;
import com.example.rxexample2.databinding.ActivityMainBinding;
import com.example.rxexample2.presenter.BasePresenter;
import com.example.rxexample2.presenter.RepoInfoPresenter;
import com.example.rxexample2.presenter.vo.Branch;
import com.example.rxexample2.presenter.vo.Contributor;
import com.example.rxexample2.presenter.vo.Repository;
import com.example.rxexample2.view.adapters.BranchesAdapter;
import com.example.rxexample2.view.adapters.ContributorsAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class RepoInfoFragment extends BaseFragment implements RepoInfoView {

    private static final String BUNDLE_REPO_KEY = "BUNDLE_REPO_KEY";

    private FragmentRepoInfoBinding binding;

    TextView info;

    RecyclerView branchesRecyclerView;

    RecyclerView contributorsRecyclerView;

    View layout;

    private RepoInfoPresenter presenter;

    public static RepoInfoFragment newInstance(Repository repository) {
        RepoInfoFragment myFragment = new RepoInfoFragment();

        Bundle args = new Bundle();
        args.putSerializable(BUNDLE_REPO_KEY, repository);
        myFragment.setArguments(args);

        return myFragment;
    }


    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }

    private Repository getRepositoryVO() {
        return (Repository) getArguments().getSerializable(BUNDLE_REPO_KEY);
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRepoInfoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        String infoText = getRepositoryVO().getRepoName() + " (" + getRepositoryVO().getOwnerName() + ")";
        info.setText(infoText);

        branchesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        contributorsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        presenter = new RepoInfoPresenter(this, getRepositoryVO());
        presenter.onCreate(savedInstanceState);

        return view;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }


    @Override
    public void showError(String error) {
        makeToast(error);
    }


    private void makeToast(String text) {
        Snackbar.make(layout, text, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showContributors(List<Contributor> contributors) {
        branchesRecyclerView.setAdapter(new ContributorsAdapter(contributors));
    }

    @Override
    public void showBranches(List<Branch> branches) {
        contributorsRecyclerView.setAdapter(new BranchesAdapter(branches));

    }

}
