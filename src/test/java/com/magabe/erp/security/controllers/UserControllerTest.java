package com.magabe.erp.security.controllers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.magabe.erp.security.models.User;
import com.magabe.erp.security.services.RoleService;
import com.magabe.erp.security.services.UserService;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Disabled;

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
import org.springframework.ui.ConcurrentModel;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @MockBean
    private RoleService roleService;

    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link UserController#addNew(com.magabe.erp.security.models.User, org.springframework.web.servlet.mvc.support.RedirectAttributes)}
     */
    @Test
    void testAddNew() throws Exception {
        doNothing().when(this.userService).save((com.magabe.erp.security.models.User) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/addNew");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/login"));
    }

    /**
     * Method under test: {@link UserController#getAll(org.springframework.ui.Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAll() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.magabe.erp.security.controllers.UserController.getAll(UserController.java:26)
        //   In order to prevent getAll(Model)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAll(Model).
        //   See https://diff.blue/R013 to resolve this issue.

        UserController userController = new UserController();
        userController.getAll(new ConcurrentModel());
    }

    /**
     * Method under test: {@link UserController#addNew(com.magabe.erp.security.models.User, org.springframework.web.servlet.mvc.support.RedirectAttributes)}
     */
    @Test
    void testAddNew2() throws Exception {
        doNothing().when(this.userService).save((com.magabe.erp.security.models.User) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/users/addNew");
        postResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/login"));
    }

    /**
     * Method under test: {@link UserController#editUser(Integer, String, org.springframework.ui.Model)}
     */
    @Test
    void testEditUser() throws Exception {
        User user = new User();
        user.setFirstname("Jane");
        user.setId(1);
        user.setLastname("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");
        when(this.userService.findById(anyInt())).thenReturn(user);
        when(this.roleService.getUserNotRoles((User) any())).thenReturn(new ArrayList<>());
        when(this.roleService.getUserRoles((User) any())).thenReturn(new HashSet<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/security/user/{op}/{id}", "Op", 1);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(3))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user", "userNotRoles", "userRoles"))
                .andExpect(MockMvcResultMatchers.view().name("/security/userOp"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/security/userOp"));
    }

    /**
     * Method under test: {@link UserController#editUser(Integer, String, org.springframework.ui.Model)}
     */
    @Test
    void testEditUser2() throws Exception {
        User user = new User();
        user.setFirstname("Jane");
        user.setId(1);
        user.setLastname("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUsername("janedoe");
        when(this.userService.findById(anyInt())).thenReturn(user);
        when(this.roleService.getUserNotRoles((User) any())).thenReturn(new ArrayList<>());
        when(this.roleService.getUserRoles((User) any())).thenReturn(new HashSet<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/security/user/{op}/{id}", "Op", 1);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(3))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user", "userNotRoles", "userRoles"))
                .andExpect(MockMvcResultMatchers.view().name("/security/userOp"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/security/userOp"));
    }
}

