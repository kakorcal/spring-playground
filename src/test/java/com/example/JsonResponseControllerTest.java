package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by kennethkorcal on 2/23/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(JsonResponseController.class)
public class JsonResponseControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testJsonResponse() throws Exception {
        MockHttpServletRequestBuilder request = get("/response")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.people[0].name", is("John")));
    }
}
