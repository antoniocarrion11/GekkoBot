package org.bot;

import ca.tristan.easycommands.EasyCommands;
import ca.tristan.easycommands.commands.defaults.HelpCmd;
import net.dv8tion.jda.api.JDA;
import org.bot.commands.ExampleSlashCmd;
import org.bot.commands.LastMatchCmd;
import org.bot.commands.UserInfoCmd;
import org.bot.riot.api.ValorantController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;


@SpringBootApplication
public class GekkoBotApp {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        EasyCommands easyCommands = new EasyCommands();
        JDA jda = easyCommands
                .registerListeners()
                .addExecutor(
                        new HelpCmd(easyCommands),
                        new ExampleSlashCmd(),
                        new UserInfoCmd(),
                        new LastMatchCmd())
                .addEnabledCacheFlags()
                .addGatewayIntents()
                .buildJDA();

        ValorantController controller = new ValorantController();
        controller.getUser("SlugBino", "1060");
    }
}