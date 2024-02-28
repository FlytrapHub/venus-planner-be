package com.flytrap.venusplanner.global.auth.config;

import com.flytrap.venusplanner.global.auth.infrastructure.properties.GitHubOAuthProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({GitHubOAuthProperties.class})
public class OAuthPropertiesConfig {

}
