package com.example;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kennethkorcal on 2/19/17.
 */

@RestController
public class EndpointsController {
    @PostMapping("/post")
    public String postEndpoint() {
        return "Post request";
    }

    @DeleteMapping("/delete")
    public  String deleteEndpoint() {
        return "Delete request";
    }
}
