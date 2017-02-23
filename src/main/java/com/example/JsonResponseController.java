package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kennethkorcal on 2/23/17.
 */

@RestController
public class JsonResponseController {
    @GetMapping("/response")
    public PersonData getPersonData() {
        PersonData personData = new PersonData();
        PersonData.Data data = new PersonData.Data();
        PersonData.Person person = new PersonData.Person(1, "John");
        List<PersonData.Person> list = new ArrayList<>();

        list.add(person);
        data.setPeople(list);
        personData.setData(data);

        return personData;
    }
}
