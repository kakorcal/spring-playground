package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @GetMapping("/individual")
    public String getIndividualParam(@RequestParam String foo) {
        return String.format("Param value: %s", foo);
    }

    @GetMapping("/map")
    public String getMapParams(@RequestParam Map queryString) {
        return queryString.toString();
    }

    @GetMapping("/custom")
    public String getCustomParams(CustomInfo customInfo) {
        return String.format("Name is %s. Age is %s", customInfo.getName(), customInfo.getAge());
    }
}
