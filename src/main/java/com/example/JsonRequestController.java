package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kennethkorcal on 2/22/17.
 */

class SearchRequestParams {
    private String q;
    private String from;
    public String getQ() { return q; }
    public void setQ(String q) { this.q = q; }
    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }
}

class Json {
    private Data data;

    public Data getData() { return data; }
    public void setData(Data data) { this.data = data; }

    static class Data {
        private List<Person> people;

        public List<Person> getPeople() { return people; }
        public void setPeople(List<Person> people) { this.people = people; }
    }

    static class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
}

@RestController
public class JsonRequestController {
    @PostMapping("/string")
    public String getJsonStringLiteral(@RequestBody SearchRequestParams data) {
        return "q=" + data.getQ() + " from=" + data.getFrom();
    }

    @PostMapping("/serialize")
    public String getJsonSerializeGson(@RequestBody SearchRequestParams data) {
        return "q=" + data.getQ() + " from=" + data.getFrom();
    }

    @PostMapping("/file")
    public String getJsonNested(@RequestBody Json json) {
        return json.getData().getPeople().get(0).getName();
    }
}
