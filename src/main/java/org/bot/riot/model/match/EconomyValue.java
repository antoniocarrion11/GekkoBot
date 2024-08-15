package org.bot.riot.model.match;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EconomyValue {
  public int overall;
  public int average;

  public EconomyValue(int overall, int average) {
    this.overall = overall;
    this.average = average;
  }
}
