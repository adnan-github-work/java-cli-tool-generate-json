package com.cli.tool.commands;

import com.cli.tool.model.People;

public interface Command {
    public People generatePersonJSON();
}
