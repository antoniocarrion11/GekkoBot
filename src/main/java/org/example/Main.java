package org.example;

import ca.tristan.easycommands.EasyCommands;
import ca.tristan.easycommands.commands.defaults.HelpCmd;
import net.dv8tion.jda.api.JDA;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        EasyCommands easyCommands = new EasyCommands();
        JDA jda = easyCommands
                .registerListeners()
                .addExecutor(
                        new HelpCmd(easyCommands),
                        new ExampleSlashCmd())
                .addEnabledCacheFlags()
                .addGatewayIntents()
                .buildJDA();
    }
}