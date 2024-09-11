package org.bot.riot.api;

import org.bot.riot.model.ApiResponse;
import org.bot.riot.model.match.MatchResponse;
import org.bot.riot.model.player.PlayerResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

public class ValorantController {

    // Spring boot's way to fetch data from a url
    private final RestTemplate restTemplate;

    // Need to implement safer way to hide api key
    private final String apiKey = System.getenv("HENRIK_DEV_KEY");

    public ValorantController() {
        restTemplate =
                new RestTemplateBuilder()
                        .uriTemplateHandler(new DefaultUriBuilderFactory("https://api.henrikdev.xyz/valorant/"))
                        .build();
    }

    // Need to call this with a slash command next
    // to get data using the discord bot
    public PlayerResponse getUser(String name, String tag) {

        // getForObject automatically serializes the
        // response into a java object for us
        // spring boot has more or less become a
        // glorified jackson serializer + a wrapper
        // for url fetches

        return restTemplate.getForObject(
                "v2/account/{name}/{tag}?api_key={api_key}", PlayerResponse.class, name, tag, apiKey);
    }

    // Attempting to use Spring's entity class instead of my own response class
    // it is supposed to prove an object with the status code of my request
    public ResponseEntity<PlayerResponse> getUserEntity(String name, String tag) {

        // getForObject automatically serializes the
        // response into a java object for us
        // spring boot has more or less become a
        // glorified jackson serializer + a wrapper
        // for url fetches
        ResponseEntity<PlayerResponse> response;

        try {
            response = restTemplate.getForEntity(
                    "v2/account/{name}/{tag}?api_key={api_key}", PlayerResponse.class, name, tag, apiKey);
            if (response.getStatusCode() != HttpStatus.OK) {
                throw new Exception();
            }
            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new PlayerResponse(HttpStatus.NOT_FOUND.value(), null), HttpStatus.NOT_FOUND);
        }
    }

    // Need to call this with a slash command next
    // to get data using the discord bot
    // Can call endpoint
    // /valorant/v4/matches/{region}/{platform}/{name}/{tag}
    // with queries:
    // ?mode=(competitive,deathmatch, etc)
    // ?map=(Icebox, Ascent, etc)
    // and ?size=(Amount of matches to get)
    // for test purposes here is an example match id
    // 24e300bb-5d6d-4286-9042-8ca55e9e32a7

    public ApiResponse getLastMatch(String name, String tag, String mode) {
        ApiResponse apiResponse = null;
        try {
            apiResponse =
                    restTemplate.getForObject(
                            "v4/matches/na/pc/{name}/{tag}?mode={mode}&size=1&api_key={apikey}",
                            MatchResponse.class,
                            name,
                            tag,
                            mode,
                            apiKey);
        } catch (Exception e) {

        }

        return apiResponse;
    }
}
