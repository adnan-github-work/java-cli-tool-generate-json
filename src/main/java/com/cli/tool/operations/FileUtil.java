package com.cli.tool.operations;

import com.cli.tool.model.Person;
import com.cli.tool.model.People;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.cli.tool.model.Person.generatePerson;

public class FileUtil {

    private static final Logger LOGGER = Logger.getLogger(FileUtil.class.getName());

    private static String fileName;
    private static final String DEFAULT_SEPARATOR = ",";

    public FileUtil(String fileName) {
        this.fileName = fileName;
    }

    public People readFile() {
        BufferedReader br = null;
        String line = "";
        People people = null;
        List<Person> personList = new ArrayList<Person>();
        int firstLineFlag = 0;

        try {
            br = new BufferedReader(new FileReader(fileName));
            for (; ((line = br.readLine()) != null); ) {
                if (firstLineFlag != 0) {
                    String personArray[] = line.split(DEFAULT_SEPARATOR);
                    Person person = generatePerson(personArray);
                    if (person != null) {
                        personList.add(person);
                    }
                } else {
                    firstLineFlag = 1;
                }
                people = new People.Builder().setPerson(personList).build();
            }

        } catch (FileNotFoundException e) {
            LOGGER.info(fileName + " file not found");
        } catch (IOException e) {
            LOGGER.info("There is some technical problem while reading file: " + fileName);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return people;
    }
}
