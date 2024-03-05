package com.flytrap.venusplanner.global.exception.custom;

/**
 * 외부 API 요청에 실패했을 때 발생하는 예외입니다.
 */
public class ApiRequestFailureException extends RuntimeException {

    public ApiRequestFailureException(String message) {
        super(message);
    }
}
