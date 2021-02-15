package com.cli.tool.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;

public class Person implements Serializable {

    private String firstName;

    private String lastName;


    private int age;

    @JsonIgnore
    private String nationality;

    private String favouriteColour;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public String getFavouriteColour() {
        return favouriteColour;
    }

    public Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.nationality = builder.nationality;
        this.favouriteColour = builder.favouriteColor;
    }

    public static class Builder {

        private String firstName;
        private int age;
        private String lastName;
        private String nationality;
        private String favouriteColor;

        public Builder() {

        }

        public Builder(Person person) {
            this.firstName = person.firstName;
            this.lastName = person.lastName;
            this.age = person.age;
            this.nationality = person.nationality;
            this.favouriteColor = person.favouriteColour;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withNationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public Builder withFavouriteColor(String favouriteColor) {
            this.favouriteColor = favouriteColor;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public static Person generatePerson(String[] personArray) {
        if (personArray.length == 5) {
            return new Person.Builder()
                    .withFirstName(personArray[0])
                    .withLastName(personArray[1])
                    .withAge(Integer.parseInt(personArray[2]))
                    .withNationality(personArray[3])
                    .withFavouriteColor(personArray[4])
                    .build();
        } else {
            return null;
        }
    }

}
