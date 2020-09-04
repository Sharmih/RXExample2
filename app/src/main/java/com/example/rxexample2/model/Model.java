package com.example.rxexample2.model;

import com.example.rxexample2.model.dto.BranchDTO;
import com.example.rxexample2.model.dto.ContributorDTO;
import com.example.rxexample2.model.dto.RepositoryDTO;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface Model {

    Observable<List<RepositoryDTO>> getRepoList(String name);

    Observable<List<BranchDTO>> getRepoBranches(String owner, String name);

    Observable<List<ContributorDTO>> getRepoContributors(String owner, String name);
}
