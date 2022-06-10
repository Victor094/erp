package com.magabe.erp.recruitment.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.magabe.erp.recruitment.entities.Candidate;
import com.magabe.erp.recruitment.repostories.CandidateRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CandidateServiceImp.class})
@ExtendWith(SpringExtension.class)
class CandidateServiceImpTest {
    @MockBean
    private CandidateRepository candidateRepository;

    @Autowired
    private CandidateServiceImp candidateServiceImp;

    @MockBean
    private JavaMailSender javaMailSender;

    /**
     * Method under test: {@link CandidateServiceImp#registerEmployee(Candidate)}
     */
    @Test
    void testRegisterEmployee() {
        Candidate candidate = new Candidate();
        candidate.setAddress("42 Main St");
        candidate.setEmail("jane.doe@example.org");
        candidate.setFirstName("Jane");
        candidate.setGender("Gender");
        candidate.setId(1);
        candidate.setLastName("Doe");
        candidate.setPassword("iloveyou");
        candidate.setPostalCode("Postal Code");
        candidate.setRate(1);
        candidate.setSuccessful(1);
        when(this.candidateRepository.save((Candidate) any())).thenReturn(candidate);

        Candidate candidate1 = new Candidate();
        candidate1.setAddress("42 Main St");
        candidate1.setEmail("jane.doe@example.org");
        candidate1.setFirstName("Jane");
        candidate1.setGender("Gender");
        candidate1.setId(1);
        candidate1.setLastName("Doe");
        candidate1.setPassword("iloveyou");
        candidate1.setPostalCode("Postal Code");
        candidate1.setRate(1);
        candidate1.setSuccessful(1);
        this.candidateServiceImp.registerEmployee(candidate1);
        verify(this.candidateRepository).save((Candidate) any());
        assertEquals("42 Main St", candidate1.getAddress());
        assertEquals(1, candidate1.getSuccessful());
        assertEquals(1, candidate1.getRate());
        assertEquals("Postal Code", candidate1.getPostalCode());
        assertEquals("iloveyou", candidate1.getPassword());
        assertEquals("Doe", candidate1.getLastName());
        assertEquals(1, candidate1.getId());
        assertEquals("Gender", candidate1.getGender());
        assertEquals("Jane", candidate1.getFirstName());
        assertEquals("jane.doe@example.org", candidate1.getEmail());
        assertTrue(this.candidateServiceImp.getAllCandidates().isEmpty());
    }

    /**
     * Method under test: {@link CandidateServiceImp#registerEmployee(Candidate)}
     */
    @Test
    void testRegisterEmployee2() {
        when(this.candidateRepository.save((Candidate) any())).thenThrow(new RuntimeException("An error occurred"));

        Candidate candidate = new Candidate();
        candidate.setAddress("42 Main St");
        candidate.setEmail("jane.doe@example.org");
        candidate.setFirstName("Jane");
        candidate.setGender("Gender");
        candidate.setId(1);
        candidate.setLastName("Doe");
        candidate.setPassword("iloveyou");
        candidate.setPostalCode("Postal Code");
        candidate.setRate(1);
        candidate.setSuccessful(1);
        assertThrows(RuntimeException.class, () -> this.candidateServiceImp.registerEmployee(candidate));
        verify(this.candidateRepository).save((Candidate) any());
    }

    /**
     * Method under test: {@link CandidateServiceImp#getCandidateById(long)}
     */
    @Test
    void testGetCandidateById() {
        Candidate candidate = new Candidate();
        candidate.setAddress("42 Main St");
        candidate.setEmail("jane.doe@example.org");
        candidate.setFirstName("Jane");
        candidate.setGender("Gender");
        candidate.setId(1);
        candidate.setLastName("Doe");
        candidate.setPassword("iloveyou");
        candidate.setPostalCode("Postal Code");
        candidate.setRate(1);
        candidate.setSuccessful(1);
        Optional<Candidate> ofResult = Optional.of(candidate);
        when(this.candidateRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(candidate, this.candidateServiceImp.getCandidateById(123L));
        verify(this.candidateRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link CandidateServiceImp#getCandidateById(long)}
     */
    @Test
    void testGetCandidateById2() {
        when(this.candidateRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> this.candidateServiceImp.getCandidateById(123L));
        verify(this.candidateRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link CandidateServiceImp#getCandidateById(long)}
     */
    @Test
    void testGetCandidateById3() {
        when(this.candidateRepository.findById((Integer) any())).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.candidateServiceImp.getCandidateById(123L));
        verify(this.candidateRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link CandidateServiceImp#getAllCandidates()}
     */
    @Test
    void testGetAllCandidates() {
        when(this.candidateRepository.findAll()).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.candidateServiceImp.getAllCandidates());
        verify(this.candidateRepository).findAll();
    }

    /**
     * Method under test: {@link CandidateServiceImp#getHighlyRatedCandidates()}
     */
    @Test
    void testGetHighlyRatedCandidates() {
        ArrayList<Candidate> candidateList = new ArrayList<>();
        when(this.candidateRepository.findAllHighRatings(anyInt())).thenReturn(candidateList);
        List<Candidate> actualHighlyRatedCandidates = this.candidateServiceImp.getHighlyRatedCandidates();
        assertSame(candidateList, actualHighlyRatedCandidates);
        assertTrue(actualHighlyRatedCandidates.isEmpty());
        verify(this.candidateRepository).findAllHighRatings(anyInt());
    }

    /**
     * Method under test: {@link CandidateServiceImp#getHighlyRatedCandidates()}
     */
    @Test
    void testGetHighlyRatedCandidates2() throws MailException {
        doNothing().when(this.javaMailSender).send((org.springframework.mail.SimpleMailMessage) any());

        Candidate candidate = new Candidate();
        candidate.setAddress("42 Main St");
        candidate.setEmail("jane.doe@example.org");
        candidate.setFirstName("Jane");
        candidate.setGender("Gender");
        candidate.setId(1);
        candidate.setLastName("Doe");
        candidate.setPassword("iloveyou");
        candidate.setPostalCode("Postal Code");
        candidate.setRate(1);
        candidate.setSuccessful(1);

        ArrayList<Candidate> candidateList = new ArrayList<>();
        candidateList.add(candidate);
        when(this.candidateRepository.findAllHighRatings(anyInt())).thenReturn(candidateList);
        List<Candidate> actualHighlyRatedCandidates = this.candidateServiceImp.getHighlyRatedCandidates();
        assertSame(candidateList, actualHighlyRatedCandidates);
        assertEquals(1, actualHighlyRatedCandidates.size());
        verify(this.javaMailSender).send((org.springframework.mail.SimpleMailMessage) any());
        verify(this.candidateRepository).findAllHighRatings(anyInt());
    }

    /**
     * Method under test: {@link CandidateServiceImp#getHighlyRatedCandidates()}
     */
    @Test
    void testGetHighlyRatedCandidates3() throws MailException {
        doThrow(new RuntimeException("An error occurred")).when(this.javaMailSender)
                .send((org.springframework.mail.SimpleMailMessage) any());

        Candidate candidate = new Candidate();
        candidate.setAddress("42 Main St");
        candidate.setEmail("jane.doe@example.org");
        candidate.setFirstName("Jane");
        candidate.setGender("Gender");
        candidate.setId(1);
        candidate.setLastName("Doe");
        candidate.setPassword("iloveyou");
        candidate.setPostalCode("Postal Code");
        candidate.setRate(1);
        candidate.setSuccessful(1);

        ArrayList<Candidate> candidateList = new ArrayList<>();
        candidateList.add(candidate);
        when(this.candidateRepository.findAllHighRatings(anyInt())).thenReturn(candidateList);
        assertThrows(RuntimeException.class, () -> this.candidateServiceImp.getHighlyRatedCandidates());
        verify(this.javaMailSender).send((org.springframework.mail.SimpleMailMessage) any());
        verify(this.candidateRepository).findAllHighRatings(anyInt());
    }

    /**
     * Method under test: {@link CandidateServiceImp#deleteCandidateByid(long)}
     */
    @Test
    void testDeleteCandidateByid() {
        doNothing().when(this.candidateRepository).deleteById((Integer) any());
        this.candidateServiceImp.deleteCandidateByid(123L);
        verify(this.candidateRepository).deleteById((Integer) any());
        assertTrue(this.candidateServiceImp.getAllCandidates().isEmpty());
    }

    /**
     * Method under test: {@link CandidateServiceImp#deleteCandidateByid(long)}
     */
    @Test
    void testDeleteCandidateByid2() {
        doThrow(new RuntimeException("An error occurred")).when(this.candidateRepository).deleteById((Integer) any());
        assertThrows(RuntimeException.class, () -> this.candidateServiceImp.deleteCandidateByid(123L));
        verify(this.candidateRepository).deleteById((Integer) any());
    }

    /**
     * Method under test: {@link CandidateServiceImp#sendEmail(Candidate)}
     */
    @Test
    void testSendEmail() throws MailException {
        doNothing().when(this.javaMailSender).send((org.springframework.mail.SimpleMailMessage) any());

        Candidate candidate = new Candidate();
        candidate.setAddress("42 Main St");
        candidate.setEmail("jane.doe@example.org");
        candidate.setFirstName("Jane");
        candidate.setGender("Gender");
        candidate.setId(1);
        candidate.setLastName("Doe");
        candidate.setPassword("iloveyou");
        candidate.setPostalCode("Postal Code");
        candidate.setRate(1);
        candidate.setSuccessful(1);
        this.candidateServiceImp.sendEmail(candidate);
        verify(this.javaMailSender).send((org.springframework.mail.SimpleMailMessage) any());
    }

    /**
     * Method under test: {@link CandidateServiceImp#sendEmail(Candidate)}
     */
    @Test
    void testSendEmail2() throws MailException {
        doThrow(new RuntimeException("An error occurred")).when(this.javaMailSender)
                .send((org.springframework.mail.SimpleMailMessage) any());

        Candidate candidate = new Candidate();
        candidate.setAddress("42 Main St");
        candidate.setEmail("jane.doe@example.org");
        candidate.setFirstName("Jane");
        candidate.setGender("Gender");
        candidate.setId(1);
        candidate.setLastName("Doe");
        candidate.setPassword("iloveyou");
        candidate.setPostalCode("Postal Code");
        candidate.setRate(1);
        candidate.setSuccessful(1);
        assertThrows(RuntimeException.class, () -> this.candidateServiceImp.sendEmail(candidate));
        verify(this.javaMailSender).send((org.springframework.mail.SimpleMailMessage) any());
    }
}

