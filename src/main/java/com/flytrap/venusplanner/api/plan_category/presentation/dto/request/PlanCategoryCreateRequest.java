package com.flytrap.venusplanner.api.plan_category.presentation.dto.request;

import com.flytrap.venusplanner.api.plan_category.domain.PlanCategory;
import com.flytrap.venusplanner.global.annotation.color_code.ColorCode;
import jakarta.validation.constraints.Size;

public record PlanCategoryCreateRequest(

        @Size(max = 50, message = "제목은 50자 이하로 작성해주세요.")
        String title,

        @ColorCode
        String fontColor,

        @ColorCode
        String backgroundColor
) {
    public PlanCategory toEntity(Long studyId) {
        return PlanCategory.builder()
                .studyId(studyId)
                .title(title)
                .fontColor(fontColor)
                .backgroundColor(backgroundColor)
                .build();
    }
}
