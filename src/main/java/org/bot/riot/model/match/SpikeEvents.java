package org.bot.riot.model.match;

import lombok.Getter;
import lombok.Setter;
import org.bot.riot.model.player.PlayerData;

@Getter
@Setter
public class SpikeEvents {
  private PlayerData player;
  private String site;

  public SpikeEvents(PlayerData player, String site) {
    this.player = player;
    this.site = site;
  }
}
