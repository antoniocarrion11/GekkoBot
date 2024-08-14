package org.bot.riot.model.player;

import org.bot.riot.model.AbstractResponseClass;

import java.util.Collections;

public class PlayerResponse extends AbstractResponseClass {

    private PlayerData data;

    public PlayerResponse(int status, PlayerData data) {
        super(status, Collections.emptyList());
        this.data = data;
    }

    public PlayerData getResponseData() {
        return data;
    }

    public void setResponseData(PlayerData data) {
        this.data = data;
    }
}