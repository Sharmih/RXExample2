package com.example.rxexample2.presenter.mappers;

import com.example.rxexample2.model.dto.BranchDTO;
import com.example.rxexample2.presenter.vo.Branch;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class RepoBranchesMapper implements Func1<List<BranchDTO>, List<Branch>> {

    @Override
    public List<Branch> call(List<BranchDTO> branchDTOs) {
        List<Branch> branches = Observable.from(branchDTOs)
                .map(branchDTO -> new Branch(branchDTO.getName()))
                .toList()
                .toBlocking()
                .first();
        return branches;
    }
}
