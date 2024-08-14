package org.bot.riot.model.error;

import org.bot.riot.model.AbstractResponseClass;
import org.bot.riot.model.ResponseData;

import java.util.List;

public class ErrorResponse extends AbstractResponseClass {

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
