package com.flytrap.venusplanner.api.auth_member.presentation.controller;

import com.flytrap.venusplanner.api.auth_member.business.service.AuthMemberService;
import com.flytrap.venusplanner.api.member.domain.Member;
import com.flytrap.venusplanner.api.auth_member.presentation.dto.LoginDto;
import com.flytrap.venusplanner.global.auth.dto.SessionMember;
import com.flytrap.venusplanner.global.auth.infrastructure.properties.AuthSessionProperties;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthMemberController {

    private final AuthSessionProperties authSessionProperties;
    private final AuthMemberService authMemberService;

    @PostMapping("/auth/sign-in")
    public ResponseEntity<LoginDto.Response> signIn(
            @RequestBody LoginDto.Request request,
            HttpSession session
    ) {
        Member member = authMemberService.authenticateAndFetchMember(request);
        session.setAttribute(authSessionProperties.sessionName(), SessionMember.from(member));

        return ResponseEntity.ok().body(LoginDto.Response.from(member));
    }

    @DeleteMapping("/auth/sign-out")
    public ResponseEntity<Void> signOut(HttpSession session) {

        session.invalidate();

        return ResponseEntity.noContent().build();
    }
}
