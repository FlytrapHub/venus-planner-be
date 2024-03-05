package com.flytrap.venusplanner.global.auth.exception;

import com.flytrap.venusplanner.global.exception.custom.AuthenticationFailedException;

public class SessionMemberAuthException extends AuthenticationFailedException {
    public SessionMemberAuthException() {
        super("로그인이 필요한 기능입니다.");
    }
}
