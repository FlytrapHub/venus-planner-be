package com.flytrap.venusplanner.global.exception.custom;

/**
 * 로그인 되지 않음, 로그인 실패, session 없음 등의 회원 인증에 문제가 있을 경우 발생하는 예외입니다.
 * 이 예외가 발생한 경우 응답 상태 코드는 401 Unauthorized를 반환해 주세요.
 */
public class AuthenticationFailedException extends RuntimeException {

    public AuthenticationFailedException(String message) {
        super(message);
    }
}
