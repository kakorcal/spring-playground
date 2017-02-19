package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;


import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by kennethkorcal on 2/19/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(FormDataController.class)
public class FormDataControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void getFormDataAsString() throws Exception {
        MockHttpServletRequestBuilder request = post("/string")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "John");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("name=John")));
    }

    @Test
    public void getFormDataAsHashMap() throws Exception {
        MockHttpServletRequestBuilder request = post("/map")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("foo", "bar")
                .param("bar", "baz");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{foo=bar, bar=baz}"));
    }

    @Test
    public void getFormDataAsCustomObject() throws Exception {
        MockHttpServletRequestBuilder request = post("/custom")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("firstName", "John")
                .param("lastName", "Doe");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("John Doe"));
    }
}
