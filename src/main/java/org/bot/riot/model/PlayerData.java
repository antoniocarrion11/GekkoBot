package org.bot.riot.model;

public class PlayerData {
    private String puuid;
    private String region;
    private String name;
    private String tag;
    private String card;
    private String title;
    private String[] platforms;
    private String accountLevel;

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

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String[] platforms) {
        this.platforms = platforms;
    }

    public String getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(String accountLevel) {
        this.accountLevel = accountLevel;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
