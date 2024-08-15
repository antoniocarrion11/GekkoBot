package org.bot.riot.model.match;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.bot.riot.model.player.PlayerData;

@Getter
@Setter
public class Kill {
  private int round;
  private PlayerData killer;
  private PlayerData victim;
  private ValorantAsset weapon;
  private List<PlayerData> assistants;

  public Kill(int round, PlayerData killer, ValorantAsset weapon, PlayerData victim, List<PlayerData> assistants) {
    this.round = round;
    this.killer = killer;
    this.weapon = weapon;
    this.victim = victim;
    this.assistants = assistants;
  }
}
