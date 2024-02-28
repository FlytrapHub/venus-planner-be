package com.flytrap.venusplanner.global.auth.exception;

public class SessionMemberAuthException extends RuntimeException {
    public SessionMemberAuthException() {
        super("로그인이 필요한 기능입니다.");
    }
}
