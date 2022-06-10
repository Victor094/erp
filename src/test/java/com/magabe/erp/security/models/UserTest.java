package com.magabe.erp.security.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setFirstname(String)}
     *   <li>{@link User#setId(Integer)}
     *   <li>{@link User#setLastname(String)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setRoles(Set)}
     *   <li>{@link User#setUsername(String)}
     *   <li>{@link User#getFirstname()}
     *   <li>{@link User#getId()}
     *   <li>{@link User#getLastname()}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getRoles()}
     *   <li>{@link User#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setFirstname("Jane");
        actualUser.setId(1);
        actualUser.setLastname("Doe");
        actualUser.setPassword("iloveyou");
        HashSet<Role> roleSet = new HashSet<>();
        actualUser.setRoles(roleSet);
        actualUser.setUsername("janedoe");
        assertEquals("Jane", actualUser.getFirstname());
        assertEquals(1, actualUser.getId().intValue());
        assertEquals("Doe", actualUser.getLastname());
        assertEquals("iloveyou", actualUser.getPassword());
        assertSame(roleSet, actualUser.getRoles());
        assertEquals("janedoe", actualUser.getUsername());
    }
}

