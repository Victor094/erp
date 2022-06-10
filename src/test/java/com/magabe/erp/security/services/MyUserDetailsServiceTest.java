package com.magabe.erp.security.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.magabe.erp.security.models.User;
import com.magabe.erp.security.repositories.UserRepository;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MyUserDetailsService.class})
@ExtendWith(SpringExtension.class)
class MyUserDetailsServiceTest {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link MyUserDetailsService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        User user = new User();
        user.setFirstname("Jane");
        user.setId(1);
        user.setLastname("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");
        when(this.userRepository.findByUsername((String) any())).thenReturn(user);
        assertEquals("janedoe", this.myUserDetailsService.loadUserByUsername("janedoe").getUsername());
        verify(this.userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link MyUserDetailsService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        when(this.userRepository.findByUsername((String) any()))
                .thenThrow(new UsernameNotFoundException("User not found!"));
        assertThrows(UsernameNotFoundException.class, () -> this.myUserDetailsService.loadUserByUsername("janedoe"));
        verify(this.userRepository).findByUsername((String) any());
    }
}

