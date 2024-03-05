package com.flytrap.venusplanner.api.member.domain;

import com.flytrap.venusplanner.api.member.exception.NoSuchOAuthPlatformTypeException;
import java.util.Arrays;
import java.util.Objects;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OAuthPlatformType {
    GITHUB(1L);

    private final Long id;

    public static OAuthPlatformType fromName(String name) {
        return Arrays.stream(OAuthPlatformType.values())
                .filter(type -> Objects.equals(type.name(), name))
                .findFirst()
                .orElseThrow(() -> new NoSuchOAuthPlatformTypeException(name));
    }

}
