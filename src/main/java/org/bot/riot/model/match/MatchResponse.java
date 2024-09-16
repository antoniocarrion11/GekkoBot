package org.bot.riot.model.match;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class MatchResponse {

    private int status;
    private List<MatchData> data;

    public MatchResponse(Integer status, List<MatchData> data) {
    this.status = status;
    this.data = data;
  }

    public MatchData getMatchData() {
      if (!data.isEmpty()) {
          return data.get(0);
      }
      return null;
  }
}
