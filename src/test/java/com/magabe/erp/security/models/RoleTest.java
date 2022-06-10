package com.magabe.erp.security.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RoleTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Role#Role()}
     *   <li>{@link Role#setDescription(String)}
     *   <li>{@link Role#setDetails(String)}
     *   <li>{@link Role#setId(Integer)}
     *   <li>{@link Role#getDescription()}
     *   <li>{@link Role#getDetails()}
     *   <li>{@link Role#getId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Role actualRole = new Role();
        actualRole.setDescription("The characteristics of someone or something");
        actualRole.setDetails("Details");
        actualRole.setId(1);
        assertEquals("The characteristics of someone or something", actualRole.getDescription());
        assertEquals("Details", actualRole.getDetails());
        assertEquals(1, actualRole.getId().intValue());
    }
}

