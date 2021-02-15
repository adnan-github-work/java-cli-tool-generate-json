package com.cli.tool;

import com.cli.tool.handlers.Handler;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import static com.cli.tool.Constants.*;

public class CLI {

    public static void main(String... args) {
        Handler.handleCommands(createOptions(), args);
    }

    private static Options createOptions() {
        Options options = new Options();

        options.addOption(Option.builder("d")
                .longOpt(DIRECT_INPUT)
                .hasArg(true)
                .desc("require user direct input to give person details  and then generate the json output")
                .required(false)
                .build());
        options.addOption(Option.builder("f")
                .longOpt(FILE_INPUT)
                .hasArg(true)
                .desc("require text file as an input to give person details  and then generate the json output")
                .required(false)
                .build());
        return options;
    }


}
