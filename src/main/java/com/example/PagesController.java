package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kennethkorcal on 2/19/17.
 */

@RestController
public class PagesController {
    @GetMapping("/helloworld")
    public String helloworld() {
        return "Hello World!";
    }
}
