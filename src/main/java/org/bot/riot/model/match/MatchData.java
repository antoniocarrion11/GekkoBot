package org.bot.riot.model.match;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bot.riot.model.player.PlayerData;

import java.util.List;

@Getter
@Setter
@Builder
public class MatchData {

    private Metadata metadata;
    private List<PlayerData> players;
    private List<Round> rounds;
    private List<Kill> kills;

    public MatchData(Metadata metadata, List<PlayerData> players, List<Round> rounds, List<Kill> kills) {
        this.rounds = rounds;
        this.players = players;
        this.metadata = metadata;
        this.kills = kills;
    }
}
