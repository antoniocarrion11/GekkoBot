package org.bot;

import org.bot.commands.ExampleSlashCmd;
import ca.tristan.easycommands.EasyCommands;
import ca.tristan.easycommands.commands.defaults.HelpCmd;
import net.dv8tion.jda.api.JDA;

import java.io.IOException;
import java.net.URISyntaxException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class GekkoBotApp {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        SpringApplication.run(GekkoBotApp.class, args);

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