package com.example;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by kennethkorcal on 2/19/17.
 */

@RestController
public class FormDataController {

    @PostMapping("/string")
    public String getRawString(@RequestBody String rawBody) {
        return rawBody;
    }

    @PostMapping(value = "/map", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getMapParams(@RequestParam Map<String, String> formData) {
        return formData.toString();
    }


    @PostMapping(value = "/custom", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getObjectParams(CustomFormData customFormData) {
        return customFormData.getFirstName() + " " +  customFormData.getLastName();
    }
}
