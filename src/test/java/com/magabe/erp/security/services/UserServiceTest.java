package com.magabe.erp.security.services;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.magabe.erp.security.models.User;
import com.magabe.erp.security.repositories.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserService.class, BCryptPasswordEncoder.class})
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * Method under test: {@link UserService#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<User> userList = new ArrayList<>();
        when(this.userRepository.findAll()).thenReturn(userList);
        List<User> actualFindAllResult = this.userService.findAll();
        assertSame(userList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.userRepository).findAll();
    }

    /**
     * Method under test: {@link UserService#findById(int)}
     */
    @Test
    void testFindById() {
        User user = new User();
        user.setFirstname("Jane");
        user.setId(1);
        user.setLastname("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(user, this.userService.findById(1));
        verify(this.userRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link UserService#delete(int)}
     */
    @Test
    void testDelete() {
        doNothing().when(this.userRepository).deleteById((Integer) any());
        this.userService.delete(1);
        verify(this.userRepository).deleteById((Integer) any());
        assertTrue(this.userService.findAll().isEmpty());
    }

    /**
     * Method under test: {@link UserService#save(User)}
     */
    @Test
    void testSave() {
        User user = new User();
        user.setFirstname("Jane");
        user.setId(1);
        user.setLastname("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user);

        User user1 = new User();
        user1.setFirstname("Jane");
        user1.setId(1);
        user1.setLastname("Doe");
        user1.setPassword("iloveyou");
        user1.setRoles(new HashSet<>());
        user1.setUsername("janedoe");
        this.userService.save(user1);
        verify(this.userRepository).save((User) any());
    }
}

