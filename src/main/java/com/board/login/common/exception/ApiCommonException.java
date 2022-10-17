package com.board.login.common.exception;

import com.board.login.common.doc.ApiError;
import lombok.Getter;

@Getter
public class ApiCommonException extends RuntimeException{
    private final ApiError apiError;

    public ApiCommonException(ApiError apiError) {
        super(apiError.getErrorMessage());
        this.apiError = apiError;
    }

    public ApiCommonException(ApiError apiError, String message) {
        super(message);
        this.apiError = apiError;
    }
}
