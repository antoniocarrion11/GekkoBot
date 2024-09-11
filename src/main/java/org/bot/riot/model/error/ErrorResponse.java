package org.bot.riot.model.error;

import lombok.Getter;
import lombok.Setter;
import org.bot.riot.model.ApiResponse;

import java.util.List;

@Getter
@Setter
public class ErrorResponse extends ApiResponse {
    protected List<ErrorResponseData> errors;

    public ErrorResponse(int status, List<ErrorResponseData> errors) {
        super(status);
        this.errors = errors;
    }
}
