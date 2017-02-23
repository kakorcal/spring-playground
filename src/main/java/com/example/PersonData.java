package com.example;

import java.util.List;

/**
 * Created by kennethkorcal on 2/23/17.
 */
class PersonData {
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
