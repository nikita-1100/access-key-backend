package com.example.accesskeybackend.template.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-dev.properties")
class WebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void checkIpv6SupportTrue() throws Exception {
        this.mockMvc.perform(get("/api/web/checkIpv6Support?siteAddress=google.com"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("true")));
    }

    @Test
    void checkIpv6SupportFalse() throws Exception {
        this.mockMvc.perform(get("/api/web/checkIpv6Support?siteAddress=bikeprotect.ru"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("false")));
    }
}