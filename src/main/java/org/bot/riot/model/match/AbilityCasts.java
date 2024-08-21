package org.bot.riot.model.match;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbilityCasts {
  private int grenade;
  private int ability1;
  private int ability2;
  private int ultimate;

  public AbilityCasts(int grenade, int ability1, int ability2, int ultimate) {
    this.grenade = grenade;
    this.ability1 = ability1;
    this.ability2 = ability2;
    this.ultimate = ultimate;
  }
}
