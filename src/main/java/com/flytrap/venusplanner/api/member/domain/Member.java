package com.flytrap.venusplanner.api.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oauthPk;
    private Long oauthPlatformId;
    private String email;
    private String profileImageUrl;
    private String nickname;

    @CreationTimestamp
    private Instant createdTime;

    @Builder
    public Member(String oauthPk, Long oauthPlatformId, String email, String profileImageUrl, String nickname) {
        this.oauthPk = oauthPk;
        this.oauthPlatformId = oauthPlatformId;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
    }

}
