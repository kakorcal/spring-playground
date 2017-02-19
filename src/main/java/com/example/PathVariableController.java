package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by kennethkorcal on 2/19/17.
 */

@RestController
public class PathVariableController {
    @GetMapping("/individual/{id}")
    public String getIndividualPathVariable(@PathVariable int id) {
        return String.format("Id is %d", id);
    }

    @GetMapping("/map/{id}/posts/{postId}")
    public String getHashMapPathVariables(@PathVariable Map pathVariables) {
        return pathVariables.toString();
    }

    @GetMapping("/custom/{id}/posts/{postId}")
    public String getCustomObjectPathVariables(CustomPathVariable pathVariables) {
        return String.format("Id is %d. Post id is %d", pathVariables.getId(), pathVariables.getPostId());
    }
}
