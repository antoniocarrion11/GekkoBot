package org.bot.riot.api;

import org.bot.riot.model.AbstractResponse;
import org.bot.riot.model.player.PlayerResponse;
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

    //Need to call this with a slash command next to get data using the discord bot
    public AbstractResponse getUser(String name, String tag) {

        // getForObject automatically serializes the response into a java object for us
        // spring boot has more or less become a glorified jackson serializer + a wrapper for url fetches
        AbstractResponse restTemplateUser = restTemplate.getForObject("/account/{name}/{tag}?api_key={api_key}", PlayerResponse.class, name, tag, apiKey);

        return restTemplateUser;
    }

    //Need to call this with a slash command next to get data using the discord bot
    // Can call endpoint /valorant/v3/matches/{region}/{name}/{tag}
    // with queries:
    // ?mode=(competitive,deathmatch, etc)
    // ?map=(Icebox, Ascent, etc)
    // and ?size=(Amount of matches to get)
    // for test purposes here is an example match id 24e300bb-5d6d-4286-9042-8ca55e9e32a7

    public PlayerResponse getMatches(String name, String tag) {

        // getForObject automatically serializes the response into a java object for us
        // spring boot has more or less become a glorified jackson serializer + a wrapper for url fetches
        PlayerResponse restTemplateUser = restTemplate.getForObject("/account/{name}/{tag}?api_key={api_key}", PlayerResponse.class, name, tag, apiKey);

        System.out.println("restTemplateUser: " + restTemplateUser);
        System.out.println("Userid: " + restTemplateUser.getResponseData().getPuuid());
        System.out.println("Name: " + restTemplateUser.getResponseData().getName());
        System.out.println("Tag: " + restTemplateUser.getResponseData().getTag());

        return restTemplateUser;
    }
}
