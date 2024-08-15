package org.bot.riot.model.match;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoundEconomy {
  private int loadout_value;
  private int remaining;
  private ValorantAsset weapon;
  private ValorantAsset armor;

  public RoundEconomy(int loadout_value, int remaining, ValorantAsset weapon, ValorantAsset armor) {
    this.loadout_value = loadout_value;
    this.remaining = remaining;
    this.weapon = weapon;
    this.armor = armor;
  }
}
