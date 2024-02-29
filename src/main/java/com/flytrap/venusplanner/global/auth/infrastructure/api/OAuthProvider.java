package com.flytrap.venusplanner.global.auth.infrastructure.api;

import com.flytrap.venusplanner.global.auth.infrastructure.dto.StandardizedUserResource;

public interface OAuthProvider {

    StandardizedUserResource authenticateAndFetchUserResource(String code);
}
