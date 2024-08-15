package org.bot.riot.model.match;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Metadata {
  private String matchid;
  private ValorantAsset map;
  private ValorantAsset queue;
  private String cluster;

  public Metadata(ValorantAsset map, ValorantAsset queue, String matchid, String cluster) {
    this.map = map;
    this.queue = queue;
    this.matchid = matchid;
    this.cluster = cluster;
  }
}
