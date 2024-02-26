package com.flytrap.venusplanner.api.plan.business.service;

import com.flytrap.venusplanner.api.plan.domain.Plan;
import com.flytrap.venusplanner.api.plan.domain.RecurringOption;
import com.flytrap.venusplanner.api.plan.infrastructure.repository.PlanRepository;
import com.flytrap.venusplanner.api.plan_category.domain.PlanCategory;
import com.flytrap.venusplanner.api.study.domain.Study;
import com.flytrap.venusplanner.api.study_plan.presentation.dto.request.StudyPlanCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlanService {

    private final PlanRepository planRepository;

    public Long savePlan(Study study, PlanCategory planCategory, StudyPlanCreateRequest request) {
        // TODO 반복 옵션 만들기
        RecurringOption recurringOption = null;
        Plan plan = request.toEntity(study, planCategory, recurringOption);
        planRepository.save(plan);

        return plan.getId();
    }
}
