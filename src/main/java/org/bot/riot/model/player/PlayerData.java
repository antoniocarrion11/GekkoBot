package org.bot.riot.model.player;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerData implements ResponseData {
    @JsonProperty("puuid")
  private String puuid;

    @JsonProperty("name")
  private String name;

    @JsonProperty("tag")
  private String tag;

    @JsonProperty("card")
  private String card;

    @JsonProperty("title")
  private String title;

    @JsonProperty("team")
    @JsonAlias("team_id")
  private String team;

    @JsonProperty("party_id")
  private String party_id;

    @JsonProperty("agent")
  private ValorantAsset agent;

    @JsonProperty("stats")
  private Stats stats;

    @JsonProperty("ability_casts")
  private AbilityCasts ability_casts;

    @JsonProperty("account_level")
    @JsonAlias("level")
    private int account_level;

    @JsonProperty("economy")
  private OverallEconomy economy;

  public PlayerData(
      String puuid,
      String name,
      String title,
      String card,
      String tag,
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
