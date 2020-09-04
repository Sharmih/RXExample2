package com.example.rxexample2.presenter.mappers;

import com.example.rxexample2.model.dto.RepositoryDTO;

import java.util.List;

public class RepoListMapper implements Func1<List<RepositoryDTO>, List<Repository>> {
    @Override
    public List<Repository> call(List<RepositoryDTO> repositoryDTOs) {
        List<Repository> repoList = Observable.from(repositoryDTOs)
                .map(repoDTO -> new Repository(repoDTO.getName(), repoDTO.getOwner().getLogin()))
                .toList()
                .toBlocking()
                .first();
        return repoList;
    }

}
