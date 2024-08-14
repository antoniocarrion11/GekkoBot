package org.bot.riot.model.error;

import org.bot.riot.model.AbstractResponse;
import org.bot.riot.model.ResponseData;

import java.util.List;

public class ErrorResponse extends AbstractResponse {

    public ErrorResponse(int status, List<ErrorResponseData> errors) {
        super(status, errors);
    }

    @Override
    public ResponseData getResponseData() {
        ErrorResponseData error = new ErrorResponseData();
        if (!errors.isEmpty()) {
            error = errors.get(0);
        }
        return error;
    }
}
