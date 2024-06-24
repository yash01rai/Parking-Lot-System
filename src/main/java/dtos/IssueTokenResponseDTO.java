package dtos;

import models.Token;

public class IssueTokenResponseDTO {

    private Token token;

    private ResponseStatus requestStatus;

    private String failureMessage;


    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public ResponseStatus getResponseStatus() {
        return requestStatus;
    }

    public void setResponseStatus(ResponseStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }
}
