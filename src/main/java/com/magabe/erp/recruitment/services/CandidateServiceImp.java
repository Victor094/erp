package com.magabe.erp.recruitment.services;

import com.magabe.erp.recruitment.entities.Candidate;
import com.magabe.erp.recruitment.repostories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CandidateServiceImp implements CandidateService {

    @Autowired
    CandidateRepository candidateRepository;
    @Autowired(required = false)
    JavaMailSender javaMailSender;


    public void registerEmployee(Candidate candidate){
        candidateRepository.save(candidate);
    }

    @Override
    public Candidate getCandidateById(long id) {
        Optional<Candidate> optional = candidateRepository.findById(((int) id));
        Candidate candidate = null;
        if (optional.isPresent()) {
            candidate = optional.get();
        } else {
            throw new RuntimeException(" Candidate not found for id :: " + id);
        }
        return candidate;
    }
    @Override
    public List<Candidate> getAllCandidates() {
        return (List<Candidate>) candidateRepository.findAll();
    }

    @Override
    public List<Candidate> getHighlyRatedCandidates() {

        int rate = 1;
        List<Candidate> candidateList = candidateRepository.findAllHighRatings(rate);
        for(int i=0; i < candidateList.size(); ++i){
                sendEmail(candidateList.get(i));
            }
        return  candidateList;
    }

    public void sendEmail(Candidate candidate) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("magabevic@gmail.com");
        message.setTo(candidate.getEmail());
        message.setSubject("Subject: Interview Invitation");
        message.setText("Dear " + candidate.getFirstName() + candidate.getLastName() +
                "Thank you for applying to the [JOB TITLE] position at [COMPANY NAME]. We’ve reviewed your application materials carefully, and we’re excited to invite you to interview for the role! \n" +
                "\n" +
                "Your interview will be conducted on teams and last roughly 30 minutes. You’ll be speaking with [INTERVIEWER], our [INTERVIEWER JOB TITLE] here at [COMPANY NAME].\n" +
                "\n" +
                "Please let us know when you are available during the following times [DATE – TIME, TIME ZONE]\n" +
                "\n" +
                "Thanks again for your interest in joining the [COMPANY NAME] team! We’re looking forward to speaking with you.\n" +
                "\n" +
                "Best,\n" +
                "\n" +
                "[Human Resource]");

        javaMailSender.send(message);

    }
}
