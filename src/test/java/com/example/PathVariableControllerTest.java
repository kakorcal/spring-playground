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
@WebMvcTest(PathVariableController.class)
public class PathVariableControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void individualPathVariableRequest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/individual/3");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Id is 3"));

    }

    @Test
    public void hashMapPathVariableRequest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/map/3/posts/8");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{id=3, postId=8}"));
    }

    @Test
    public void customObjectPathVariableRequest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/custom/5/posts/1");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Id is 5. Post id is 1"));
    }
}
