package org.bot.riot.model.player;

import org.bot.riot.model.ResponseData;
import org.bot.riot.model.match.AbilityCasts;
import org.bot.riot.model.match.OverallEconomy;
import org.bot.riot.model.match.Stats;
import org.bot.riot.model.match.ValorantAsset;

public class PlayerData implements ResponseData {
    private String puuid;
    private String name;
    private String tag;
    private String card;
    private String title;
    public String team_id;
    public String party_id;
    public ValorantAsset agent;
    public Stats stats;
    public AbilityCasts ability_casts;
    private int accountLevel;
    private OverallEconomy economy;

    public PlayerData(String puuid,
                      String name,
                      String title,
                      String card,
                      String tag,
                      String team_id,
                      String party_id,
                      ValorantAsset agent,
                      Stats stats,
                      AbilityCasts ability_casts,
                      int accountLevel,
                      OverallEconomy economy) {
        this.puuid = puuid;
        this.name = name;
        this.title = title;
        this.card = card;
        this.tag = tag;
        this.team_id = team_id;
        this.party_id = party_id;
        this.agent = agent;
        this.stats = stats;
        this.ability_casts = ability_casts;
        this.accountLevel = accountLevel;
        this.economy = economy;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getParty_id() {
        return party_id;
    }

    public void setParty_id(String party_id) {
        this.party_id = party_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public ValorantAsset getAgent() {
        return agent;
    }

    public void setAgent(ValorantAsset agent) {
        this.agent = agent;
    }

    public AbilityCasts getAbility_casts() {
        return ability_casts;
    }

    public void setAbility_casts(AbilityCasts ability_casts) {
        this.ability_casts = ability_casts;
    }

    public int getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(int accountLevel) {
        this.accountLevel = accountLevel;
    }

    public OverallEconomy getEconomy() {
        return economy;
    }

    public void setEconomy(OverallEconomy economy) {
        this.economy = economy;
    }

    @Override
    public String getResponseType() {
        return "player";
    }
}
