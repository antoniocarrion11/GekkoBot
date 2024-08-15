package org.bot.riot.model.match;

import lombok.Getter;
import lombok.Setter;
import org.bot.riot.model.ResponseData;
import org.bot.riot.model.player.PlayerData;

import java.util.List;

@Getter
@Setter
public class MatchData implements ResponseData {
    private Metadata metadata;
    private List<PlayerData> players;
    private List<Round> rounds;
    private List<Kill> kills;

    public MatchData(List<Round> rounds, List<PlayerData> players, Metadata metadata, List<Kill> kills) {
        this.rounds = rounds;
        this.players = players;
        this.metadata = metadata;
        this.kills = kills;
    }

    @Override
    public String getResponseType() {
        return "match";
    }
}
