package com.cli.tool.commands;

import com.cli.tool.model.People;
import com.cli.tool.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class DirectInputCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(DirectInputCommand.class.getName());

    String args[];

    public DirectInputCommand(String args[]){
        this.args = args;
    }

    @Override
    public People generatePersonJSON() {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        People people = null;
        if (args.length == 6 && checkNullOrEmpty(args[1])
                && checkNullOrEmpty(args[2]) && checkNullOrEmpty(args[3])
                && checkNullOrEmpty(args[4]) && checkNullOrEmpty(args[5])) {

            if (!pattern.matcher(args[3]).matches()){
                LOGGER.info("Please pass valid age argument");
                return null;
            }
            Person person = new Person.Builder()
                    .withFirstName(args[1])
                    .withLastName(args[2])
                    .withAge(Integer.parseInt(args[3]))
                    .withNationality(args[4])
                    .withFavouriteColor(args[5])
                    .build();

            List<Person> personList = new ArrayList<>();
            personList.add(person);

            people = new People.Builder()
                    .setPerson(personList)
                    .build();

            try {
                LOGGER.info(people.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            LOGGER.info("Please pass valid argument");
        }
        return people;
    }

    private  boolean checkNullOrEmpty(String str) {
        if (null == str || str.isEmpty()) {
            return false;
        }
        return true;
    }

}
