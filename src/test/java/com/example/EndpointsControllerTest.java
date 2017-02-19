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

    @Test
    public void individualParamRequest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/individual?foo=bar");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Param value: bar"));
    }

    @Test
    public void mapParamRequest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/map?foo=bar&bar=baz");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{foo=bar, bar=baz}"));
    }

    @Test
    public void customParamRequest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/custom?name=John&age=30");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Name is John. Age is 30"));
    }

}
