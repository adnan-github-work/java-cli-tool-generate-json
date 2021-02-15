package com.cli.tool.handlers;

import com.cli.tool.commands.DirectInputCommand;
import com.cli.tool.commands.ReadFileCommand;
import com.cli.tool.model.People;
import com.cli.tool.model.Person;
import com.cli.tool.operations.FileUtil;
import com.cli.tool.triggers.TriggerCLICommand;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.cli.tool.Constants.*;

public class Handler {

    private Handler() {

    }

    private static final Logger LOGGER = Logger.getLogger(Handler.class.getName());


    private static TriggerCLICommand triggerCLICommand;

    public static People handleCommands(Options options, String[] args) {
        People people = null;
        try {
            if (args.length <= 0) {
                LOGGER.info("There was no argument found, Please pass valid arguments");
                return null;
            }
            CommandLine line = new DefaultParser().parse(options, args);
            triggerCLICommand = new TriggerCLICommand();

            if (line.hasOption(DIRECT_INPUT)) {
                people = triggerReadFromUserDirectInput(args);

            } else if (line.hasOption(FILE_INPUT)) {
                String str = line.getOptionValue(FILE_INPUT);
                people = triggerReadFromFileCommand(str);
            } else {
                LOGGER.info("Invalid command");
            }

        } catch (ParseException exp) {
            LOGGER.info("Unexpected exception:" + exp.getMessage());
        } catch (Exception e) {
            LOGGER.info("There is some technical problem while handling arguments");
        }
        return people;
    }

    private static People triggerReadFromFileCommand(String str) {
        checkNullOrEmpty(str);
        triggerCLICommand.setCommand(new ReadFileCommand(new FileUtil(str)));
        return triggerCLICommand.executeCommand();
    }

    private static People triggerReadFromUserDirectInput(String[] args) {
        triggerCLICommand.setCommand(new DirectInputCommand(args));
        return triggerCLICommand.executeCommand();
    }

    public static void checkNullOrEmpty(String str) {
        if (null == str || str.isEmpty()) {
            LOGGER.info("Please pass valid argument");
        }
    }

}
