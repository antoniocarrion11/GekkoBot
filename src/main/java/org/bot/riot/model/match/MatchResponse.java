package org.bot.riot.model.match;

import java.util.Collections;
import org.bot.riot.model.AbstractResponse;

public class MatchResponse extends AbstractResponse {

  private Integer status;
  private MatchData data;

  public MatchResponse(Integer status, MatchData data) {
    super(status, Collections.emptyList());
    this.status = status;
    this.data = data;
  }

  public MatchData getResponseData() {
    return data;
  }
}
