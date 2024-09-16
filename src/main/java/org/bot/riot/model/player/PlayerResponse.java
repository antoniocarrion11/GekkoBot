package org.bot.riot.model.player;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlayerResponse {

    private int status;
    private PlayerData data;

    public PlayerResponse(int status, PlayerData data) {
        this.status = status;
        this.data = data;
    }
}