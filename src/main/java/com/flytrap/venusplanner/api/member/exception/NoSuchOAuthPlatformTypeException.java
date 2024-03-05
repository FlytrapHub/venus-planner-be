package com.flytrap.venusplanner.api.member.exception;

import com.flytrap.venusplanner.api.member.domain.OAuthPlatformType;
import com.flytrap.venusplanner.global.exception.custom.NoSuchEnumTypeException;

public class NoSuchOAuthPlatformTypeException extends NoSuchEnumTypeException {

    public NoSuchOAuthPlatformTypeException(String mismatchedTypeName) {
        super(OAuthPlatformType.class, mismatchedTypeName);
    }
}
