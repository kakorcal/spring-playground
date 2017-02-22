package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by kennethkorcal on 2/22/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(JsonRequestController.class)
public class JsonRequestControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testJsonAsStringLiteral() throws Exception {
        MockHttpServletRequestBuilder request = post("/string")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"q\": \"other\", \"from\": \"2010\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("q=other from=2010"));
    }

    @Test
    public void testJsonWithGson() throws Exception {
        JsonObject searchRequest = new JsonObject();
        searchRequest.addProperty("q", "foo");
        searchRequest.addProperty("from", "2017");

        Gson builder = new GsonBuilder().create();

        String jsonString = builder.toJson(searchRequest);

        MockHttpServletRequestBuilder request = post("/serialize")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("q=foo from=2017"));
    }

    @Test
    public void testJsonWithFile() throws Exception {
        String json = getJSON("/data.json");
        MockHttpServletRequestBuilder request = post("/file")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("John"));
    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }

}
