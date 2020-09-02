package com.example.baseconcept.payload;

public class ApiSuccessResponse<T> extends ApiDefaultResponse<T> {


    public ApiSuccessResponse(boolean success, String message, T data) {
        super(success, message, data);
    }

    public ApiSuccessResponse(T data) {
        super(true, null, null, data);
    }
}
