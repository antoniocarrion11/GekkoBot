package org.bot;

import org.bot.commands.ExampleSlashCmd;
import ca.tristan.easycommands.EasyCommands;
import ca.tristan.easycommands.commands.defaults.HelpCmd;
import net.dv8tion.jda.api.JDA;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.bot.riot.api.ValorantController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


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

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = context.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println("beanname: " + beanName);
            }
        };
    }
}