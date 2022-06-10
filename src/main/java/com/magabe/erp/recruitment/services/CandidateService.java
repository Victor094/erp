package com.magabe.erp.recruitment.services;

import com.magabe.erp.recruitment.entities.Candidate;

import java.util.List;


public interface CandidateService {
    void registerEmployee(Candidate candidate);

    Candidate getCandidateById(long id);

    List<Candidate> getAllCandidates();

    List<Candidate> getHighlyRatedCandidates();

    void deleteCandidateByid(long id);
}
