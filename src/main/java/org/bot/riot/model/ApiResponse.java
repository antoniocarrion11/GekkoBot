package org.bot.riot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
  protected Integer status;

    public ApiResponse(int status) {
    this.status = status;
  }
}
