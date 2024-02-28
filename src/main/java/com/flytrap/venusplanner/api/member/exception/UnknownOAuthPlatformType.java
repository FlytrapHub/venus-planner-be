package com.flytrap.venusplanner.api.member.exception;

public class UnknownOAuthPlatformType extends RuntimeException {
    public UnknownOAuthPlatformType(String typeName) {
        super(typeName + "은(는) 알 수 없는 플랫폼 명 입니다.");
    }
}
