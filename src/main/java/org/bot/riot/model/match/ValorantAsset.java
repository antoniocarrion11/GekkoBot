package org.bot.riot.model.match;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValorantAsset {

  private String id;
  private String name;

  public ValorantAsset(String id, String name) {
    this.id = id;
    this.name = name;
  }
}
