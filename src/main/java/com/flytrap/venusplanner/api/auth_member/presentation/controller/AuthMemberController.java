package com.flytrap.venusplanner.api.auth_member.presentation.controller;

import com.flytrap.venusplanner.api.auth_member.business.service.AuthMemberService;
import com.flytrap.venusplanner.api.auth_member.presentation.dto.LoginDto;
import com.flytrap.venusplanner.api.auth_member.presentation.dto.SessionMember;
import com.flytrap.venusplanner.api.member.domain.Member;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthMemberController {

    private final AuthMemberService authMemberService;

    @PostMapping("/auth/sign-in")
    public ResponseEntity<LoginDto.Response> signIn(
            @RequestBody LoginDto.Request request,
            HttpSession session
    ) {
        Member member = authMemberService.authenticateAndFetchMember(request);
        session.setAttribute("SESSION_NAME", SessionMember.from(member));

        return ResponseEntity.ok().body(LoginDto.Response.from(member));
    }
}
