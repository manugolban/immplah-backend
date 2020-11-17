package com.immplah.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.immplah.Ds2020TestConfig;
import com.immplah.services.DoctorService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class PersonControllerUnitTest extends Ds2020TestConfig {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoctorService service;

    @Test
    public void insertPersonTest() throws Exception {
        assert(true);
    }

    @Test
    public void insertPersonTestFailsDueToAge() throws Exception {
        assert(true);
    }

    @Test
    public void insertPersonTestFailsDueToNull() throws Exception {
        assert(true);
    }
}
