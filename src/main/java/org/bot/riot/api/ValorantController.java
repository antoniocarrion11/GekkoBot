package org.bot.riot.api;

import org.bot.riot.model.match.MatchResponse;
import org.bot.riot.model.player.PlayerData;
import org.bot.riot.model.player.PlayerResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.Collections;

public class ValorantController {

    // Spring boot's way to fetch data from an url
    private final RestTemplate restTemplate;

    // Need to implement safer way to hide api key
    private final String apiKey = System.getenv("HENRIK_DEV_KEY");

    public ValorantController() {
        restTemplate =
                new RestTemplateBuilder()
                        .uriTemplateHandler(new DefaultUriBuilderFactory("https://api.henrikdev.xyz/valorant/"))
                        .build();
    }

    // Attempting to use Spring's entity class instead of my own response class
    // it is supposed to prove an object with the status code of my request
    public ResponseEntity<PlayerResponse> getUserEntity(String name, String tag) {

        // getForEntity automatically serializes the
        // response into a java object for us
        ResponseEntity<PlayerResponse> response;

        try {
            response =
                    restTemplate.getForEntity(
                            "v2/account/{name}/{tag}?api_key={api_key}", PlayerResponse.class, name, tag, apiKey);

            if (response.getStatusCode() != HttpStatus.OK) {
                throw new Exception();
            }
            return response;

        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode());
            return new ResponseEntity<>(
                    new PlayerResponse(e.getStatusCode().value(), PlayerData.builder().build()), e.getStatusCode());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(
                    new PlayerResponse(HttpStatus.NOT_FOUND.value(), PlayerData.builder().build()), HttpStatus.NOT_FOUND);
        }
    }

    // Can call endpoint
    // /valorant/v4/matches/{region}/{platform}/{name}/{tag}
    // with queries:
    // ?mode=(competitive,deathmatch, etc)
    // ?map=(Icebox, Ascent, etc)
    // and ?size=(Amount of matches to get)
    // for test purposes here is an example match id
    // 24e300bb-5d6d-4286-9042-8ca55e9e32a7

    public ResponseEntity<MatchResponse> getLastMatch(String name, String tag, String mode) {
        ResponseEntity<MatchResponse> response;
        try {
            response =
                    restTemplate.getForEntity(
                            "v4/matches/na/pc/{name}/{tag}?mode={mode}&size=1&api_key={apikey}",
                            MatchResponse.class,
                            name,
                            tag,
                            mode,
                            apiKey);

            if (response.getStatusCode() != HttpStatus.OK) {
                throw new Exception();
            }
            return response;

        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode());
            return new ResponseEntity<>(
                    new MatchResponse(e.getStatusCode().value(), Collections.emptyList()), e.getStatusCode());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(
                    new MatchResponse(HttpStatus.NOT_FOUND.value(), Collections.emptyList()), HttpStatus.NOT_FOUND);
        }
    }
}
