package com.magabe.erp.security.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.magabe.erp.security.models.Role;
import com.magabe.erp.security.models.User;
import com.magabe.erp.security.repositories.RoleRepository;
import com.magabe.erp.security.repositories.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RoleService.class})
@ExtendWith(SpringExtension.class)
class RoleServiceTest {
    @MockBean
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link RoleService#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<Role> roleList = new ArrayList<>();
        when(this.roleRepository.findAll()).thenReturn(roleList);
        List<Role> actualFindAllResult = this.roleService.findAll();
        assertSame(roleList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.roleRepository).findAll();
    }

    /**
     * Method under test: {@link RoleService#findById(int)}
     */
    @Test
    void testFindById() {
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
        Optional<Role> ofResult = Optional.of(role);
        when(this.roleRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(role, this.roleService.findById(1));
        verify(this.roleRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link RoleService#delete(int)}
     */
    @Test
    void testDelete() {
        doNothing().when(this.roleRepository).deleteById((Integer) any());
        this.roleService.delete(1);
        verify(this.roleRepository).deleteById((Integer) any());
        assertTrue(this.roleService.findAll().isEmpty());
    }

    /**
     * Method under test: {@link RoleService#save(Role)}
     */
    @Test
    void testSave() {
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
        when(this.roleRepository.save((Role) any())).thenReturn(role);

        Role role1 = new Role();
        role1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant());
        role1.setCreatedDate(fromResult);
        role1.setDescription("The characteristics of someone or something");
        role1.setDetails("Details");
        role1.setId(1);
        role1.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant());
        role1.setLastModifiedDate(fromResult1);
        this.roleService.save(role1);
        verify(this.roleRepository).save((Role) any());
        assertEquals("Jan 1, 2020 8:00am GMT+0100", role1.getCreatedBy());
        assertSame(fromResult1, role1.getLastModifiedDate());
        assertEquals("Jan 1, 2020 9:00am GMT+0100", role1.getLastModifiedBy());
        assertEquals(1, role1.getId().intValue());
        assertEquals("Details", role1.getDetails());
        assertEquals("The characteristics of someone or something", role1.getDescription());
        assertSame(fromResult, role1.getCreatedDate());
        assertTrue(this.roleService.findAll().isEmpty());
    }

    /**
     * Method under test: {@link RoleService#assignUserRole(Integer, Integer)}
     */
    @Test
    void testAssignUserRole() {
        User user = new User();
        user.setFirstname("Jane");
        user.setId(1);
        user.setLastname("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);

        User user1 = new User();
        user1.setFirstname("Jane");
        user1.setId(1);
        user1.setLastname("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles(new HashSet<>());
        user1.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user1);
        when(this.userRepository.findById((Integer) any())).thenReturn(ofResult);

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
        Optional<Role> ofResult1 = Optional.of(role);
        when(this.roleRepository.findById((Integer) any())).thenReturn(ofResult1);
        this.roleService.assignUserRole(123, 123);
        verify(this.userRepository).save((User) any());
        verify(this.userRepository).findById((Integer) any());
        verify(this.roleRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link RoleService#assignUserRole(Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAssignUserRole2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.magabe.erp.security.services.RoleService.assignUserRole(RoleService.java:46)
        //   In order to prevent assignUserRole(Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   assignUserRole(Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        User user = new User();
        user.setFirstname("Jane");
        user.setId(1);
        user.setLastname("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user);
        when(this.userRepository.findById((Integer) any())).thenReturn(Optional.empty());

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
        Optional<Role> ofResult = Optional.of(role);
        when(this.roleRepository.findById((Integer) any())).thenReturn(ofResult);
        this.roleService.assignUserRole(123, 123);
    }

    /**
     * Method under test: {@link RoleService#unassignUserRole(Integer, Integer)}
     */
    @Test
    void testUnassignUserRole() {
        User user = new User();
        user.setFirstname("Jane");
        user.setId(1);
        user.setLastname("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);

        User user1 = new User();
        user1.setFirstname("Jane");
        user1.setId(1);
        user1.setLastname("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles(new HashSet<>());
        user1.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user1);
        when(this.userRepository.findById((Integer) any())).thenReturn(ofResult);
        this.roleService.unassignUserRole(123, 123);
        verify(this.userRepository).save((User) any());
        verify(this.userRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link RoleService#unassignUserRole(Integer, Integer)}
     */
    @Test
    void testUnassignUserRole2() {
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

        User user = new User();
        user.setFirstname("Jane");
        user.setId(1);
        user.setLastname("Doe");
        user.setPassword("iloveyou");
        user.setRoles(roleSet);
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);

        User user1 = new User();
        user1.setFirstname("Jane");
        user1.setId(1);
        user1.setLastname("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles(new HashSet<>());
        user1.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user1);
        when(this.userRepository.findById((Integer) any())).thenReturn(ofResult);
        this.roleService.unassignUserRole(123, 123);
        verify(this.userRepository).save((User) any());
        verify(this.userRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link RoleService#unassignUserRole(Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUnassignUserRole3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.magabe.erp.security.services.RoleService.unassignUserRole(RoleService.java:55)
        //   In order to prevent unassignUserRole(Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   unassignUserRole(Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        User user = new User();
        user.setFirstname("Jane");
        user.setId(1);
        user.setLastname("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user);
        when(this.userRepository.findById((Integer) any())).thenReturn(Optional.empty());
        this.roleService.unassignUserRole(123, 123);
    }

    /**
     * Method under test: {@link RoleService#getUserRoles(User)}
     */
    @Test
    void testGetUserRoles() {
        User user = new User();
        user.setFirstname("Jane");
        user.setId(1);
        user.setLastname("Doe");
        user.setPassword("iloveyou");
        HashSet<Role> roleSet = new HashSet<>();
        user.setRoles(roleSet);
        user.setUsername("janedoe");
        Set<Role> actualUserRoles = this.roleService.getUserRoles(user);
        assertSame(roleSet, actualUserRoles);
        assertTrue(actualUserRoles.isEmpty());
    }

    /**
     * Method under test: {@link RoleService#getUserRoles(User)}
     */
    @Test
    void testGetUserRoles2() {
        User user = mock(User.class);
        HashSet<Role> roleSet = new HashSet<>();
        when(user.getRoles()).thenReturn(roleSet);
        doNothing().when(user).setFirstname((String) any());
        doNothing().when(user).setId((Integer) any());
        doNothing().when(user).setLastname((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRoles((Set<Role>) any());
        doNothing().when(user).setUsername((String) any());
        user.setFirstname("Jane");
        user.setId(1);
        user.setLastname("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");
        Set<Role> actualUserRoles = this.roleService.getUserRoles(user);
        assertSame(roleSet, actualUserRoles);
        assertTrue(actualUserRoles.isEmpty());
        verify(user).getRoles();
        verify(user).setFirstname((String) any());
        verify(user).setId((Integer) any());
        verify(user).setLastname((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRoles((Set<Role>) any());
        verify(user).setUsername((String) any());
    }

    /**
     * Method under test: {@link RoleService#geUserRoles(User)}
     */
    @Test
    void testGeUserRoles() {
        User user = new User();
        user.setFirstname("Jane");
        user.setId(1);
        user.setLastname("Doe");
        user.setPassword("iloveyou");
        HashSet<Role> roleSet = new HashSet<>();
        user.setRoles(roleSet);
        user.setUsername("janedoe");
        Set<Role> actualGeUserRolesResult = this.roleService.geUserRoles(user);
        assertSame(roleSet, actualGeUserRolesResult);
        assertTrue(actualGeUserRolesResult.isEmpty());
    }

    /**
     * Method under test: {@link RoleService#geUserRoles(User)}
     */
    @Test
    void testGeUserRoles2() {
        User user = mock(User.class);
        HashSet<Role> roleSet = new HashSet<>();
        when(user.getRoles()).thenReturn(roleSet);
        doNothing().when(user).setFirstname((String) any());
        doNothing().when(user).setId((Integer) any());
        doNothing().when(user).setLastname((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRoles((Set<Role>) any());
        doNothing().when(user).setUsername((String) any());
        user.setFirstname("Jane");
        user.setId(1);
        user.setLastname("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");
        Set<Role> actualGeUserRolesResult = this.roleService.geUserRoles(user);
        assertSame(roleSet, actualGeUserRolesResult);
        assertTrue(actualGeUserRolesResult.isEmpty());
        verify(user).getRoles();
        verify(user).setFirstname((String) any());
        verify(user).setId((Integer) any());
        verify(user).setLastname((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRoles((Set<Role>) any());
        verify(user).setUsername((String) any());
    }

    /**
     * Method under test: {@link RoleService#getUserNotRoles(User)}
     */
    @Test
    void testGetUserNotRoles() {
        ArrayList<Role> roleList = new ArrayList<>();
        when(this.roleRepository.getUserNotRoles((Integer) any())).thenReturn(roleList);

        User user = new User();
        user.setFirstname("Jane");
        user.setId(1);
        user.setLastname("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");
        List<Role> actualUserNotRoles = this.roleService.getUserNotRoles(user);
        assertSame(roleList, actualUserNotRoles);
        assertTrue(actualUserNotRoles.isEmpty());
        verify(this.roleRepository).getUserNotRoles((Integer) any());
    }
}

