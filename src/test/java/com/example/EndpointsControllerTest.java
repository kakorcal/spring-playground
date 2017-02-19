package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by kennethkorcal on 2/19/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(EndpointsController.class)
public class EndpointsControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testPostRequest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/post");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Post request"));
    }

    @Test
    public void testDeleteRequest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.delete("/delete");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Delete request"));

    }

}
