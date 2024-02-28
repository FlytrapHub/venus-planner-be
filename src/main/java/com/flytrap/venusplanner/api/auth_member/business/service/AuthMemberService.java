package com.flytrap.venusplanner.api.auth_member.business.service;

import com.flytrap.venusplanner.api.member.infrastructure.repository.MemberRepository;
import com.flytrap.venusplanner.api.member.domain.Member;
import com.flytrap.venusplanner.api.auth_member.presentation.dto.LoginDto;
import com.flytrap.venusplanner.global.auth.infrastructure.api.OAuthProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthMemberService {

    private final OAuthProvider oAuthProvider;
    private final MemberRepository memberRepository;

    @Transactional
    public Member authenticateAndFetchMember(LoginDto.Request request) {

        var userResource = oAuthProvider.authenticateAndFetchMember(request.code());
        var authenticatedMember = memberRepository.findByOauthPk(userResource.oauthPk())
                .orElse(Member.from(userResource));

        memberRepository.save(authenticatedMember);

        return authenticatedMember;
    }
}
