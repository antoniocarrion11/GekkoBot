package org.bot.riot.model;

import org.bot.riot.model.error.ErrorResponseData;

import java.util.List;

public abstract class AbstractResponse {
    protected Integer status;
    protected List<ErrorResponseData> errors;

    public AbstractResponse(int status, List<ErrorResponseData> errors) {
        this.status = status;
        this.errors = errors;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ErrorResponseData> getAllErrors() {
        return errors;
    }

    public void setErrors(List<ErrorResponseData> errors) {
        this.errors = errors;
    }

    public abstract ResponseData getResponseData();

}
