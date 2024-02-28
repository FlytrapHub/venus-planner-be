package com.flytrap.venusplanner.api.plan_category.domain;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class ColorCode {

    private String code;

    private ColorCode(String code) {
        validateCode(code);
        this.code = code;
    }

    public static ColorCode from(String code) {
        return new ColorCode(code);
    }

    private void validateCode(String code) {
        if (!code.matches("^#[0-9A-Fa-f]{6}$")) {
            throw new IllegalArgumentException(); // TODO 커스텀 예외로 수정
        }
    }
}
