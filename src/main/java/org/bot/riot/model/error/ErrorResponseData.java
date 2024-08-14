package org.bot.riot.model.error;

import org.bot.riot.model.ResponseData;

public class ErrorResponseData implements ResponseData {

    private String message;
    private Integer code;
    private String details;

    ErrorResponseData() {
    }

    ErrorResponseData(String message,
                      Integer code,
                      String details) {
        this.message = message;
        this.code = code;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String getResponseType() {
        return "error";
    }
}
