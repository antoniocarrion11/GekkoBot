package org.bot.riot.model.error;

import lombok.Getter;
import lombok.Setter;
import org.bot.riot.model.ResponseData;

@Getter
@Setter
public class ErrorResponseData implements ResponseData {

  private String message;
  private Integer code;
  private String details;

  ErrorResponseData() {}

  ErrorResponseData(String message, Integer code, String details) {
    this.message = message;
    this.code = code;
    this.details = details;
  }

  @Override
  public String getResponseType() {
    return "error";
  }
}
