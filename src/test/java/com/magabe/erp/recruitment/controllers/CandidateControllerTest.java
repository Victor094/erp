package com.magabe.erp.recruitment.controllers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.magabe.erp.recruitment.entities.Candidate;
import com.magabe.erp.recruitment.services.CandidateServiceImp;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CandidateController.class})
@ExtendWith(SpringExtension.class)
class CandidateControllerTest {
    @Autowired
    private CandidateController candidateController;

    @MockBean
    private CandidateServiceImp candidateServiceImp;

    /**
     * Method under test: {@link CandidateController#listCandidates(org.springframework.ui.Model)}
     */
    @Test
    void testListCandidates() throws Exception {
        when(this.candidateServiceImp.getAllCandidates()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/recruitment/candidates");
        MockMvcBuilders.standaloneSetup(this.candidateController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("candidateList"))
                .andExpect(MockMvcResultMatchers.view().name("recruitment/list_of_candidates"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("recruitment/list_of_candidates"));
    }

    /**
     * Method under test: {@link CandidateController#listCandidates(org.springframework.ui.Model)}
     */
    @Test
    void testListCandidates2() throws Exception {
        when(this.candidateServiceImp.getAllCandidates()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/recruitment/candidates");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.candidateController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("candidateList"))
                .andExpect(MockMvcResultMatchers.view().name("recruitment/list_of_candidates"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("recruitment/list_of_candidates"));
    }

    /**
     * Method under test: {@link CandidateController#processRegister(com.magabe.erp.recruitment.entities.Candidate)}
     */
    @Test
    void testProcessRegister() throws Exception {
        doNothing().when(this.candidateServiceImp).registerEmployee((com.magabe.erp.recruitment.entities.Candidate) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/process_register");
        MockMvcBuilders.standaloneSetup(this.candidateController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("candidate"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/recruitment"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/recruitment"));
    }

    /**
     * Method under test: {@link CandidateController#processRegister(com.magabe.erp.recruitment.entities.Candidate)}
     */
    @Test
    void testProcessRegister2() throws Exception {
        doNothing().when(this.candidateServiceImp).registerEmployee((com.magabe.erp.recruitment.entities.Candidate) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/process_register");
        postResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.candidateController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("candidate"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/recruitment"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/recruitment"));
    }

    /**
     * Method under test: {@link CandidateController#ShortListedCandidates(org.springframework.ui.Model)}
     */
    @Test
    void testShortListedCandidates() throws Exception {
        when(this.candidateServiceImp.getHighlyRatedCandidates()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/recruitment/send-email-shortlisted");
        MockMvcBuilders.standaloneSetup(this.candidateController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("candidateList"))
                .andExpect(MockMvcResultMatchers.view().name("recruitment/shortlisted_candidates"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("recruitment/shortlisted_candidates"));
    }

    /**
     * Method under test: {@link CandidateController#ShortListedCandidates(org.springframework.ui.Model)}
     */
    @Test
    void testShortListedCandidates2() throws Exception {
        when(this.candidateServiceImp.getHighlyRatedCandidates()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/recruitment/send-email-shortlisted");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.candidateController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("candidateList"))
                .andExpect(MockMvcResultMatchers.view().name("recruitment/shortlisted_candidates"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("recruitment/shortlisted_candidates"));
    }

    /**
     * Method under test: {@link CandidateController#showFormForDeleteCandidate(long, org.springframework.ui.Model)}
     */
    @Test
    void testShowFormForDeleteCandidate() throws Exception {
        doNothing().when(this.candidateServiceImp).deleteCandidateByid(anyLong());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/recruitment/candidates/delete/{id}",
                123L);
        MockMvcBuilders.standaloneSetup(this.candidateController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/recruitment/candidates"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/recruitment/candidates"));
    }

    /**
     * Method under test: {@link CandidateController#showFormForDeleteCandidate(long, org.springframework.ui.Model)}
     */
    @Test
    void testShowFormForDeleteCandidate2() throws Exception {
        doNothing().when(this.candidateServiceImp).deleteCandidateByid(anyLong());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/recruitment/candidates/delete/{id}", 123L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.candidateController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/recruitment/candidates"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/recruitment/candidates"));
    }

    /**
     * Method under test: {@link CandidateController#showFormForUpdate(long, org.springframework.ui.Model)}
     */
    @Test
    void testShowFormForUpdate() throws Exception {
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
        when(this.candidateServiceImp.getCandidateById(anyLong())).thenReturn(candidate);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/recruitment/candidates/edit/{id}",
                123L);
        MockMvcBuilders.standaloneSetup(this.candidateController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("candidate"))
                .andExpect(MockMvcResultMatchers.view().name("recruitment/EditRateCandidates"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("recruitment/EditRateCandidates"));
    }

    /**
     * Method under test: {@link CandidateController#showFormForUpdate(long, org.springframework.ui.Model)}
     */
    @Test
    void testShowFormForUpdate2() throws Exception {
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
        when(this.candidateServiceImp.getCandidateById(anyLong())).thenReturn(candidate);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/recruitment/candidates/edit/{id}", 123L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.candidateController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("candidate"))
                .andExpect(MockMvcResultMatchers.view().name("recruitment/EditRateCandidates"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("recruitment/EditRateCandidates"));
    }

    /**
     * Method under test: {@link CandidateController#showLeaveForm(org.springframework.ui.Model)}
     */
    @Test
    void testShowLeaveForm() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/recruitment/register-candidate");
        MockMvcBuilders.standaloneSetup(this.candidateController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("candidate"))
                .andExpect(MockMvcResultMatchers.view().name("recruitment/register_candidate_form"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("recruitment/register_candidate_form"));
    }

    /**
     * Method under test: {@link CandidateController#showLeaveForm(org.springframework.ui.Model)}
     */
    @Test
    void testShowLeaveForm2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/recruitment/register-candidate");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.candidateController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("candidate"))
                .andExpect(MockMvcResultMatchers.view().name("recruitment/register_candidate_form"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("recruitment/register_candidate_form"));
    }
}

