package org.bot.riot.model.match;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OverallEconomy {
    private EconomyValue spent;
    private EconomyValue loadout_value;

    public OverallEconomy(EconomyValue spent, EconomyValue loadout_value) {
        this.spent = spent;
        this.loadout_value = loadout_value;
    }
}
