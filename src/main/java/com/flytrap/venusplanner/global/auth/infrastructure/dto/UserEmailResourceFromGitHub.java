package com.flytrap.venusplanner.global.auth.infrastructure.dto;

public record UserEmailResourceFromGitHub(
        String email,
        boolean verified,
        boolean primary,
        String visibility
) {
}
