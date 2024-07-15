package org.bot.commands;

import ca.tristan.easycommands.commands.EventData;
import ca.tristan.easycommands.commands.slash.SlashExecutor;

public class ExampleSlashCmd extends SlashExecutor {

    @Override
    public String getName() {
        return "intro";
    }

    @Override
    public String getDescription() {
        return "introduces gekko org.bot";
    }

    @Override
    public void execute(EventData event) {
        event.reply("Buenos! It's Gekko Bot!\n I'm the guy in the chair for my agents!", false).queue();
    }
}
