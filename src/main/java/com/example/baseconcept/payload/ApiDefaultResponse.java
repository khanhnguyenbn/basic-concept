package com.example.baseconcept.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiDefaultResponse<T> {

    protected boolean success;
    protected String message;
    @JsonProperty("error_code")
    protected String errorCode;
    protected T data;

    public ApiDefaultResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ApiDefaultResponse(boolean success, String message, String errorCode, T data) {
        this.success = success;
        this.message = message;
        this.errorCode = errorCode;
        this.data = data;
    }
}
