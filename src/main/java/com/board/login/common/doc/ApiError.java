package com.board.login.common.doc;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ApiError {
    COMMON_SUCCESS(HttpStatus.OK, "000000", "정상적으로 처리 되었습니다."),
    COMMON_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E99999", "서버오류가 발생 하였습니다. 관리자에게 문의해 주세요."),
    COMMON_RESOURCE_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, "E00000", "해당 자원이 존재하지 않습니다."),
    COMMON_DUPLICATION_DATA(HttpStatus.BAD_REQUEST, "E00001", "중복된 자원이 존재 합니다."),
    REQUEST_INVALID(HttpStatus.BAD_REQUEST, "E10000", "올바르지 않은 요청 입니다."),
    NOTEXIST_SCHEDULE(HttpStatus.BAD_REQUEST, "E10001", "해당 스케줄이 존재하지 않습니다."),
    EXIST_SCHEDULE(HttpStatus.BAD_REQUEST, "E10002", "해당 시간대에 예약된 스케줄이 있습니다."),
    NOTEXIST_HOLIDAY(HttpStatus.BAD_REQUEST, "E10003", "해당 공휴일이 존재하지 않습니다."),
    REQUEST_PARAM_CHECK(HttpStatus.BAD_REQUEST, "E20000", "요청 파라미터를 확인해주세요."),
    REQUEST_USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "E00100", "해당 유저를 찾을 수 없습니다."),
    REQUEST_LOGIN_FAIL(HttpStatus.BAD_REQUEST, "E00110", "로그인 실패."),
    AUTH_NOT_PERMISSION(HttpStatus.FORBIDDEN, "E90000", "권한이 없습니다."),
    NEED_ADMIN_CHECK_ACCOUNT(HttpStatus.BAD_REQUEST, "E90100", "관리자 확인이 필요한 계정입니다. 관리자에게 문의하세요."),
    ;

    ApiError(HttpStatus httpStatus, String errorCode,  String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorMessage;
}
