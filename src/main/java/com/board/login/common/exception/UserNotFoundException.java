package com.board.login.common.exception;

import com.board.login.common.doc.ApiError;

import static com.board.login.common.doc.ApiError.REQUEST_USER_NOT_FOUND;

public class UserNotFoundException extends ApiCommonException{
    public UserNotFoundException() { super(REQUEST_USER_NOT_FOUND);}

    public UserNotFoundException(String message) {
        super(REQUEST_USER_NOT_FOUND, message);
    }
}
