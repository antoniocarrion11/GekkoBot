package org.bot.riot.api;

import org.bot.riot.model.Player;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

public class ValorantController {

    // Spring boot's way to fetch data from a url
    private RestTemplate restTemplate;

    // Need to implement safer way to hide api key
    private String apiKey = System.getenv("HENRIK_DEV_KEY");

    public ValorantController() {
        restTemplate = new RestTemplateBuilder()
                .uriTemplateHandler(new DefaultUriBuilderFactory("https://api.henrikdev.xyz/valorant/v2/"))
                .build();
    }

    public String get() {
        return "Ayo! I'm Gekkobot your guy in the chair!";
    }

    //Need to call this with a slash command next to get data using the discord bot
    public String getUser(String name, String tag) {

        // getForObject automatically serializes the response into a java object for us
        // spring boot has more or less become a glorified jackson serializer + a wrapper for url fetches
        Player restTemplateUser = restTemplate.getForObject("/account/{name}/{tag}?api_key={api_key}", Player.class, name, tag, apiKey);

        System.out.println("restTemplateUser: " + restTemplateUser);
        System.out.println("Userid: " + restTemplateUser.getData().getPuuid());
        System.out.println("Name: " + restTemplateUser.getData().getName());
        System.out.println("Tag: " + restTemplateUser.getData().getTag());

        return "User";
    }
}
