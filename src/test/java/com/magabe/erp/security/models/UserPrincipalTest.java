package com.magabe.erp.security.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

class UserPrincipalTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserPrincipal#UserPrincipal(User)}
     *   <li>{@link UserPrincipal#isAccountNonExpired()}
     *   <li>{@link UserPrincipal#isAccountNonLocked()}
     *   <li>{@link UserPrincipal#isCredentialsNonExpired()}
     *   <li>{@link UserPrincipal#isEnabled()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User user = new User();
        user.setFirstname("Jane");
        user.setId(1);
        user.setLastname("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");
        UserPrincipal actualUserPrincipal = new UserPrincipal(user);
        assertTrue(actualUserPrincipal.isAccountNonExpired());
        assertTrue(actualUserPrincipal.isAccountNonLocked());
        assertTrue(actualUserPrincipal.isCredentialsNonExpired());
        assertTrue(actualUserPrincipal.isEnabled());
    }

    /**
     * Method under test: {@link UserPrincipal#getAuthorities()}
     */
    @Test
    void testGetAuthorities() {
        assertTrue((new UserPrincipal(new User())).getAuthorities().isEmpty());
    }

    /**
     * Method under test: {@link UserPrincipal#getAuthorities()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAuthorities2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.magabe.erp.security.models.UserPrincipal.getAuthorities(UserPrincipal.java:27)
        //   In order to prevent getAuthorities()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAuthorities().
        //   See https://diff.blue/R013 to resolve this issue.

        (new UserPrincipal(null)).getAuthorities();
    }

    /**
     * Method under test: {@link UserPrincipal#getAuthorities()}
     */
    @Test
    void testGetAuthorities3() {
        Role role = new Role();
        role.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        role.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        role.setDescription("The characteristics of someone or something");
        role.setDetails("Details");
        role.setId(1);
        role.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        role.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));

        HashSet<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        Collection<? extends GrantedAuthority> actualAuthorities = (new UserPrincipal(
                new User(123, "Jane", "Doe", "janedoe", "iloveyou", roleSet))).getAuthorities();
        assertEquals(1, actualAuthorities.size());
        assertEquals("The characteristics of someone or something",
                ((List<? extends GrantedAuthority>) actualAuthorities).get(0).getAuthority());
    }

    /**
     * Method under test: {@link UserPrincipal#getAuthorities()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAuthorities4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: A granted authority textual representation is required
        //       at org.springframework.util.Assert.hasText(Assert.java:287)
        //       at org.springframework.security.core.authority.SimpleGrantedAuthority.<init>(SimpleGrantedAuthority.java:38)
        //       at com.magabe.erp.security.models.UserPrincipal.getAuthorities(UserPrincipal.java:28)
        //   In order to prevent getAuthorities()
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAuthorities().
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        role.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        role.setDescription("");
        role.setDetails("Details");
        role.setId(1);
        role.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        role.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));

        HashSet<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        (new UserPrincipal(new User(123, "Jane", "Doe", "janedoe", "iloveyou", roleSet))).getAuthorities();
    }

    /**
     * Method under test: {@link UserPrincipal#getPassword()}
     */
    @Test
    void testGetPassword() {
        assertNull((new UserPrincipal(new User())).getPassword());
    }

    /**
     * Method under test: {@link UserPrincipal#getPassword()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPassword2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.magabe.erp.security.models.UserPrincipal.getPassword(UserPrincipal.java:37)
        //   In order to prevent getPassword()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPassword().
        //   See https://diff.blue/R013 to resolve this issue.

        (new UserPrincipal(null)).getPassword();
    }

    /**
     * Method under test: {@link UserPrincipal#getUsername()}
     */
    @Test
    void testGetUsername() {
        assertNull((new UserPrincipal(new User())).getUsername());
    }

    /**
     * Method under test: {@link UserPrincipal#getUsername()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUsername2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.magabe.erp.security.models.UserPrincipal.getUsername(UserPrincipal.java:42)
        //   In order to prevent getUsername()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getUsername().
        //   See https://diff.blue/R013 to resolve this issue.

        (new UserPrincipal(null)).getUsername();
    }
}

