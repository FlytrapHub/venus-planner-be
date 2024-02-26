package com.flytrap.venusplanner.api.study_plan.presentation.dto.request;

import com.flytrap.venusplanner.api.plan.domain.Plan;
import com.flytrap.venusplanner.api.plan.domain.RecurringOption;
import com.flytrap.venusplanner.api.plan_category.domain.PlanCategory;
import com.flytrap.venusplanner.api.study.domain.Study;
import java.time.Instant;

public record StudyPlanCreateRequest(
        Long categoryId,
        String title,
        String description,
        Instant startTime,
        Instant endTime,
        Instant notificationTime
) {
    public Plan toEntity(Study study, PlanCategory planCategory, RecurringOption recurringOption) {
        return Plan.builder()
                .study(study)
                .planCategory(planCategory)
                .recurringOption(recurringOption)
                .title(title)
                .description(description)
                .startTime(startTime)
                .endTime(endTime)
                .notificationTime(notificationTime)
                .build();
    }
}
