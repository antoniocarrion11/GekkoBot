package org.bot.riot.model;

public class Player {
    private Integer status;
    private String updatedAt;
    private PlayerData data;

    public PlayerData getData() {
        return data;
    }

    public void setData(PlayerData data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}