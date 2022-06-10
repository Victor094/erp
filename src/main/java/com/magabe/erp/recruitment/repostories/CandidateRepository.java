package com.magabe.erp.recruitment.repostories;

import com.magabe.erp.recruitment.entities.Candidate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {
    Candidate findByEmail(String email);
    @Query("SELECT u FROM Candidate u WHERE u.rate >= 3")
    List<Candidate> findAllHighRatings(int rate);
}