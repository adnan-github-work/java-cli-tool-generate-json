package com.cli.tool.commands;

import com.cli.tool.model.People;
import com.cli.tool.operations.FileUtil;

import java.io.IOException;
import java.util.logging.Logger;


public class ReadFileCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(ReadFileCommand.class.getName());

    FileUtil fileUtil;

    public ReadFileCommand(FileUtil fileUtil) {
        this.fileUtil = fileUtil;
    }

    @Override
    public People generatePersonJSON() {
        People people = fileUtil.readFile();
        try {
            if (null != people) {
                LOGGER.info(fileUtil.readFile().toJSONString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return people;
    }

}
