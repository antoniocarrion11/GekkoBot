package org.bot.riot.model.match;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Round {
  private String id;
  private String result;
  private String winning_team;
  private SpikeEvents plant;
  private SpikeEvents defuse;
  private boolean bomb_planted;
  private boolean bomb_defused;
  private List<PlayerRoundStats> stats;

  public Round(
      String id,
      String winning_team,
      String result,
      SpikeEvents plant,
      SpikeEvents defuse,
      List<PlayerRoundStats> stats) {
    this.id = id;
    this.winning_team = winning_team;
    this.result = result;
    this.plant = plant;
    this.defuse = defuse;
    this.bomb_planted = plant != null;
    this.bomb_defused = defuse != null;
    this.stats = stats;
  }
}
