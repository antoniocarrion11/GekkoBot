package org.bot.riot.model.match;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stats {
  private int score;
  private int kills;
  private int deaths;
  private int assists;
  private int bodyshots;
  private int headshots;
  private int legshots;

  public Stats(int score, int kills, int deaths, int bodyshots, int assists, int headshots, int legshots) {
    this.score = score;
    this.kills = kills;
    this.deaths = deaths;
    this.bodyshots = bodyshots;
    this.assists = assists;
    this.headshots = headshots;
    this.legshots = legshots;
  }
}
