package org.bot.riot.model.match;

import lombok.Getter;
import lombok.Setter;
import org.bot.riot.model.player.PlayerData;

@Getter
@Setter
public class PlayerRoundStats {
    private PlayerData player;
    private AbilityCasts ability_casts;
    private Stats stats;
    private RoundEconomy economy;

    public PlayerRoundStats(PlayerData player, AbilityCasts ability_casts, Stats stats, RoundEconomy economy) {
        this.player = player;
        this.ability_casts = ability_casts;
        this.stats = stats;
        this.economy = economy;
    }
}
