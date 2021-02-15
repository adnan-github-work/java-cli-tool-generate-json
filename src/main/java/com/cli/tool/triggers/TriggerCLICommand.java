package com.cli.tool.triggers;

import com.cli.tool.commands.Command;
import com.cli.tool.model.People;

public class TriggerCLICommand {

    Command cliCommand;

    public void setCommand(Command cliCommand)
    {
        // set the cli command to
        // execute
        this.cliCommand = cliCommand;
    }

    public People executeCommand()
    {
        return cliCommand.generatePersonJSON();
    }

}
