package com.flytrap.venusplanner.global.auth.infrastructure.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "auth.session")
public record AuthSessionProperties(
        String sessionName
) {
}
