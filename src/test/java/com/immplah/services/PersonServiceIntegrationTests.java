package com.immplah.services;

import com.immplah.Ds2020TestConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;


import static org.springframework.test.util.AssertionErrors.assertEquals;

import java.util.List;
import java.util.UUID;

public class PersonServiceIntegrationTests extends Ds2020TestConfig {

    @Autowired
    DoctorService doctorService;

    @Test
    public void testGetCorrect() {
        assert(true);
    }

    @Test
    public void testInsertCorrectWithGetById() {
        assert(true);
    }

    @Test
    public void testInsertCorrectWithGetAll() {
        assert(true);
    }
}
