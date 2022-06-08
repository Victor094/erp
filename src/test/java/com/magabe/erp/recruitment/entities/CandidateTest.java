package com.magabe.erp.recruitment.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CandidateTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Candidate}
     *   <li>{@link Candidate#setAddress(String)}
     *   <li>{@link Candidate#setEmail(String)}
     *   <li>{@link Candidate#setFirstName(String)}
     *   <li>{@link Candidate#setGender(String)}
     *   <li>{@link Candidate#setId(int)}
     *   <li>{@link Candidate#setLastName(String)}
     *   <li>{@link Candidate#setPassword(String)}
     *   <li>{@link Candidate#setPostalCode(String)}
     *   <li>{@link Candidate#setRate(int)}
     *   <li>{@link Candidate#setSuccessful(int)}
     *   <li>{@link Candidate#getAddress()}
     *   <li>{@link Candidate#getEmail()}
     *   <li>{@link Candidate#getFirstName()}
     *   <li>{@link Candidate#getGender()}
     *   <li>{@link Candidate#getId()}
     *   <li>{@link Candidate#getLastName()}
     *   <li>{@link Candidate#getPassword()}
     *   <li>{@link Candidate#getPostalCode()}
     *   <li>{@link Candidate#getRate()}
     *   <li>{@link Candidate#getSuccessful()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Candidate actualCandidate = new Candidate();
        actualCandidate.setAddress("42 Main St");
        actualCandidate.setEmail("jane.doe@example.org");
        actualCandidate.setFirstName("Jane");
        actualCandidate.setGender("Gender");
        actualCandidate.setId(1);
        actualCandidate.setLastName("Doe");
        actualCandidate.setPassword("iloveyou");
        actualCandidate.setPostalCode("Postal Code");
        actualCandidate.setRate(1);
        actualCandidate.setSuccessful(1);
        assertEquals("42 Main St", actualCandidate.getAddress());
        assertEquals("jane.doe@example.org", actualCandidate.getEmail());
        assertEquals("Jane", actualCandidate.getFirstName());
        assertEquals("Gender", actualCandidate.getGender());
        assertEquals(1, actualCandidate.getId());
        assertEquals("Doe", actualCandidate.getLastName());
        assertEquals("iloveyou", actualCandidate.getPassword());
        assertEquals("Postal Code", actualCandidate.getPostalCode());
        assertEquals(1, actualCandidate.getRate());
        assertEquals(1, actualCandidate.getSuccessful());
    }
}

