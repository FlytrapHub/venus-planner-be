package com.flytrap.venusplanner.global.auth.infrastructure.dto;

import com.flytrap.venusplanner.api.member.domain.OAuthPlatformType;

public record StandardizedUserResource(
        String oauthPk,
        String email,
        String nickname,
        String profileUrl,
        OAuthPlatformType authPlatformType
) {

}
