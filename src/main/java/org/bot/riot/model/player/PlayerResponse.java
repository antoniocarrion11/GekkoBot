package org.bot.riot.model.player;

import lombok.Setter;
import org.bot.riot.model.AbstractResponse;

import java.util.Collections;

@Setter
public class PlayerResponse extends AbstractResponse {

    private PlayerData data;

    public PlayerResponse(int status, PlayerData data) {
        super(status, Collections.emptyList());
        this.data = data;
    }

    public PlayerData getResponseData() {
        return data;
    }
}