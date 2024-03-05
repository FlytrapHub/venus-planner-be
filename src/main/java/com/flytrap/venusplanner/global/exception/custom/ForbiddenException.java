package com.flytrap.venusplanner.global.exception.custom;

/**
 * 특정 자원에 접근 권한이 없을 때 발생하는 예외입니다.
 * 이 예외가 발생한 경우 응답 상태 코드는 403 Forbidden를 반환해 주세요.
 */
public class ForbiddenException extends RuntimeException {

    public ForbiddenException(String message) {
        super(message);
    }
}
