package com.magabe.erp.security.controllers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.magabe.erp.security.models.Role;
import com.magabe.erp.security.services.RoleService;
import com.magabe.erp.security.services.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

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

@ContextConfiguration(classes = {RoleController.class})
@ExtendWith(SpringExtension.class)
class RoleControllerTest {
    @Autowired
    private RoleController roleController;

    @MockBean
    private RoleService roleService;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link RoleController#save(com.magabe.erp.security.models.Role)}
     */
    @Test
    void testSave() throws Exception {
        doNothing().when(this.roleService).save((com.magabe.erp.security.models.Role) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/security/roles");
        MockMvcBuilders.standaloneSetup(this.roleController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("role"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/security/roles"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/security/roles"));
    }

    /**
     * Method under test: {@link RoleController#save(com.magabe.erp.security.models.Role)}
     */
    @Test
    void testSave2() throws Exception {
        doNothing().when(this.roleService).save((com.magabe.erp.security.models.Role) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/security/roles");
        postResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.roleController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("role"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/security/roles"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/security/roles"));
    }

    /**
     * Method under test: {@link RoleController#assignRole(Integer, Integer)}
     */
    @Test
    void testAssignRole() throws Exception {
        doNothing().when(this.roleService).assignUserRole((Integer) any(), (Integer) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/security/role/assign/{userId}/{roleId}",
                123, 123);
        MockMvcBuilders.standaloneSetup(this.roleController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/security/user/Edit/123"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/security/user/Edit/123"));
    }

    /**
     * Method under test: {@link RoleController#delete(Integer)}
     */
    @Test
    void testDelete() throws Exception {
        doNothing().when(this.roleService).delete(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/security/role/delete/{id}", 1);
        MockMvcBuilders.standaloneSetup(this.roleController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/security/roles"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/security/roles"));
    }

    /**
     * Method under test: {@link RoleController#delete(Integer)}
     */
    @Test
    void testDelete2() throws Exception {
        doNothing().when(this.roleService).delete(anyInt());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/security/role/delete/{id}", 1);
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.roleController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/security/roles"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/security/roles"));
    }

    /**
     * Method under test: {@link RoleController#assignRole(Integer, Integer)}
     */
    @Test
    void testAssignRole2() throws Exception {
        doNothing().when(this.roleService).assignUserRole((Integer) any(), (Integer) any());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/security/role/assign/{userId}/{roleId}", 123,
                123);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.roleController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/security/user/Edit/123"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/security/user/Edit/123"));
    }

    /**
     * Method under test: {@link RoleController#getById(Integer)}
     */
    @Test
    void testGetById() throws Exception {
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
        when(this.roleService.findById(anyInt())).thenReturn(role);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/security/role/{id}", 1);
        MockMvcBuilders.standaloneSetup(this.roleController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"createdBy\":\"Jan 1, 2020 8:00am GMT+0100\",\"createdDate\":0,\"lastModifiedBy\":\"Jan 1, 2020 9:00am"
                                        + " GMT+0100\",\"lastModifiedDate\":0,\"id\":1,\"description\":\"The characteristics of someone or something\","
                                        + "\"details\":\"Details\"}"));
    }

    /**
     * Method under test: {@link RoleController#getById(Integer)}
     */
    @Test
    void testGetById2() throws Exception {
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
        when(this.roleService.findById(anyInt())).thenReturn(role);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/security/role/{id}", 1);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.roleController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"createdBy\":\"Jan 1, 2020 8:00am GMT+0100\",\"createdDate\":0,\"lastModifiedBy\":\"Jan 1, 2020 9:00am"
                                        + " GMT+0100\",\"lastModifiedDate\":0,\"id\":1,\"description\":\"The characteristics of someone or something\","
                                        + "\"details\":\"Details\"}"));
    }

    /**
     * Method under test: {@link RoleController#parameters(org.springframework.ui.Model)}
     */
    @Test
    void testParameters() throws Exception {
        when(this.roleService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/security/roles");
        MockMvcBuilders.standaloneSetup(this.roleController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("roles"))
                .andExpect(MockMvcResultMatchers.view().name("security/roles"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("security/roles"));
    }

    /**
     * Method under test: {@link RoleController#parameters(org.springframework.ui.Model)}
     */
    @Test
    void testParameters2() throws Exception {
        when(this.roleService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/security/roles");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.roleController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("roles"))
                .andExpect(MockMvcResultMatchers.view().name("security/roles"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("security/roles"));
    }

    /**
     * Method under test: {@link RoleController#unassignRole(Integer, Integer)}
     */
    @Test
    void testUnassignRole() throws Exception {
        doNothing().when(this.roleService).unassignUserRole((Integer) any(), (Integer) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/security/role/unassign/{userId}/{roleId}", 123, 123);
        MockMvcBuilders.standaloneSetup(this.roleController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/security/user/Edit/123"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/security/user/Edit/123"));
    }

    /**
     * Method under test: {@link RoleController#unassignRole(Integer, Integer)}
     */
    @Test
    void testUnassignRole2() throws Exception {
        doNothing().when(this.roleService).unassignUserRole((Integer) any(), (Integer) any());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/security/role/unassign/{userId}/{roleId}",
                123, 123);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.roleController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/security/user/Edit/123"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/security/user/Edit/123"));
    }
}

