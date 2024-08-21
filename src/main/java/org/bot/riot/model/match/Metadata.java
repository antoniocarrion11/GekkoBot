package org.bot.riot.model.match;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Metadata {
    private String match_id;
  private ValorantAsset map;
  private ValorantAsset queue;
  private String cluster;

    public Metadata(ValorantAsset map, ValorantAsset queue, String match_id, String cluster) {
    this.map = map;
    this.queue = queue;
        this.match_id = match_id;
    this.cluster = cluster;
  }
}
