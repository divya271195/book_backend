package com.jwt.jwtauth.Exceptions;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import java.util.List;
import java.util.ArrayList;



public class Error {
    private final int status;
    private final String message;
    private List<FieldError> fieldErrors = new ArrayList<>();

    Error(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void addFieldError(String path, String message) {
        FieldError error = new FieldError(path, message,"");
        fieldErrors.add(error);
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }
}
