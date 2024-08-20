package org.bot.riot.model.match;

import lombok.Setter;
import org.bot.riot.model.AbstractResponse;

import java.util.Collections;
import java.util.List;

@Setter
public class MatchResponse extends AbstractResponse {

    private List<MatchData> data;

    public MatchResponse(Integer status, List<MatchData> data) {
    super(status, Collections.emptyList());
    this.status = status;
    this.data = data;
  }

  public MatchData getResponseData() {
      if (!data.isEmpty()) {
          return data.get(0);
      }
      return null;
  }

    public List<MatchData> getMatchData() {
        return data;
  }
}
