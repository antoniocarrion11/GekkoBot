package org.bot.commands;

import ca.tristan.easycommands.commands.EventData;
import ca.tristan.easycommands.commands.slash.SlashExecutor;

public class LastMatchCmd extends SlashExecutor {


    @Override
    public String getName() {
        return "lastmatch";
    }

    @Override
    public String getDescription() {
        return "finds the stats of the last match played";
    }

    @Override
    public void execute(EventData event) {
        event.reply("Buenos! It's Gekko Bot!\n I'm the guy in the chair for my agents!", false).queue();
    }
}
