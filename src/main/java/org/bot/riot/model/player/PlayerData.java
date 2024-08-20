package org.bot.riot.model.player;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bot.riot.model.ResponseData;
import org.bot.riot.model.match.AbilityCasts;
import org.bot.riot.model.match.OverallEconomy;
import org.bot.riot.model.match.Stats;
import org.bot.riot.model.match.ValorantAsset;

@Getter
@Setter
@Builder
public class PlayerData implements ResponseData {
  private String puuid;
  private String name;
  private String tag;
  private String card;
  private String title;
  private String team_id;
  private String team;
  private String party_id;
  private ValorantAsset agent;
  private Stats stats;
  private AbilityCasts ability_casts;
    private int account_level;
  private OverallEconomy economy;

  public PlayerData(
      String puuid,
      String name,
      String title,
      String card,
      String tag,
      String team_id,
      String team,
      String party_id,
      ValorantAsset agent,
      Stats stats,
      AbilityCasts ability_casts,
      int account_level,
      OverallEconomy economy) {
    this.puuid = puuid;
    this.name = name;
    this.title = title;
    this.card = card;
    this.tag = tag;
    this.team_id = team_id;
    this.team = team;
    this.party_id = party_id;
    this.agent = agent;
    this.stats = stats;
    this.ability_casts = ability_casts;
      this.account_level = account_level;
    this.economy = economy;
  }

  @Override
  public String getResponseType() {
    return "player";
  }
}
