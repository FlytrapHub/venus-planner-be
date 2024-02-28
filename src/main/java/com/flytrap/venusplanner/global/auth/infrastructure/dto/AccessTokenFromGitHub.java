package com.flytrap.venusplanner.global.auth.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AccessTokenFromGitHub(
        @JsonProperty("access_token") String accessToken,
        @JsonProperty("token_type") String tokenType
) {
    public String getHeadValue() {
        return String.format("%s %s", tokenType, accessToken);
    }
}