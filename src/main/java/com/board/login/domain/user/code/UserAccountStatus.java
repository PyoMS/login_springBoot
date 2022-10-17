package com.board.login.domain.user.code;

import lombok.Getter;

@Getter
public enum UserAccountStatus {
    REQUEST("REQUEST", "요청", "관리자 승인 대기중 계정"),
    APPROVAL("APPROVAL", "승인", ""),
    BLOCK("BLOCK", "사용중지", "사용이 중지된 계정입니다."),
    REJECT("REJECT", "거부", "관리자 승인 거부 계정입니다.");

    private final String code;
    private final String desc;
    private final String errMessage;

    UserAccountStatus(String code, String desc, String errMessage) {
        this.code = code;
        this.desc = desc;
        this.errMessage = errMessage;
    }

}
