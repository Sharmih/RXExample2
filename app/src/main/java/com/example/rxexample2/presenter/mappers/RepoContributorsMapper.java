package com.example.rxexample2.presenter.mappers;

import com.example.rxexample2.model.dto.ContributorDTO;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class RepoContributorsMapper implements Func1<List<ContributorDTO>, List<Contributor>> {

    @Override
    public List<Contributor> call(List<ContributorDTO> branchDTOs) {
        List<Contributor> contributors = Observable.from(branchDTOs)
                .map(contributorDTO -> new Contributor(contributorDTO.getLogin()))
                .toList()
                .toBlocking()
                .first();
        return contributors;
    }
}
