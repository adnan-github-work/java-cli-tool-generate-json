package com.cli.tool.model;


import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class People implements Serializable {

    private List<Person> person;

    public List<Person> getPerson() {
        return person;
    }

    public People(Builder builder) {
        this.person = builder.personList;
    }

    public static class Builder {

        private List<Person> personList;

        public Builder() {
        }

        public Builder(People persons) {
            this.personList = persons.person;
        }

        public Builder setPerson(List<Person> personList) {
            this.personList = personList;
            return this;
        }

        public People build() {
            return new People(this);
        }
    }

    public String toJSONString() throws IOException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
    }

}
