package com.thoughtworks.ketsu.web.exception;

import java.util.ArrayList;
import java.util.List;

public class InvalidParameterException extends RuntimeException {
    List<InvalidParamMessage> invalidParamMessageList;

    public InvalidParameterException(String message) {
        super(message);
    }

    public InvalidParameterException() {
        super();
    }

    public InvalidParameterException(Exception e) {
        super(e);
    }

    public InvalidParameterException(List<String> invalidParamList) {
        invalidParamMessageList = new ArrayList();

        for( String invalidParam: invalidParamList) {
            invalidParamMessageList.add(new InvalidParamMessage(invalidParam));
        }
    }

    public List<InvalidParamMessage> getInvalidParamMessageList() {
        return invalidParamMessageList;
    }
}
