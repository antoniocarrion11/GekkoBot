package org.example;

import ca.tristan.easycommands.EasyCommands;
import ca.tristan.easycommands.commands.defaults.HelpCmd;
import net.dv8tion.jda.api.JDA;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    private static JDA jda;

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        EasyCommands ec = new EasyCommands();
        jda = ec.registerListeners().
                addExecutor(new HelpCmd(ec)).
                addEnabledCacheFlags().
                addGatewayIntents().
                buildJDA();
        System.out.println("Hello world!");
    }
}