package org.bot.riot.model.player;

import lombok.Setter;
import org.bot.riot.model.ApiResponse;

@Setter
public class PlayerResponse extends ApiResponse {

    private PlayerData data;

    public PlayerResponse(int status, PlayerData data) {
        super(status);
        this.data = data;
    }

    public PlayerData getResponseData() {
        return data;
    }
}