package org.bot.riot.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.bot.riot.model.error.ErrorResponseData;

@Getter
@Setter
public abstract class AbstractResponse {
  protected Integer status;
  protected List<ErrorResponseData> errors;

  public AbstractResponse(int status, List<ErrorResponseData> errors) {
    this.status = status;
    this.errors = errors;
  }

  public abstract ResponseData getResponseData();
}
