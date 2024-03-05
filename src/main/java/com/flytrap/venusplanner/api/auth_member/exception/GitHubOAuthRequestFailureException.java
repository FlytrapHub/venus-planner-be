package com.flytrap.venusplanner.api.auth_member.exception;

import com.flytrap.venusplanner.global.exception.custom.ApiRequestFailureException;

public class GitHubOAuthRequestFailureException extends ApiRequestFailureException {
    public GitHubOAuthRequestFailureException(String message) {
        super(message);
    }
}
