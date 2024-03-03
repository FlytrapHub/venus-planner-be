package com.flytrap.venusplanner.api.study_plan.business.service;

import com.flytrap.venusplanner.api.plan.business.service.PlanService;
import com.flytrap.venusplanner.api.plan.domain.Plan;
import com.flytrap.venusplanner.api.plan_category.business.service.PlanCategoryService;
import com.flytrap.venusplanner.api.plan_category.domain.PlanCategory;
import com.flytrap.venusplanner.api.study.business.service.StudyService;
import com.flytrap.venusplanner.api.study.domain.Study;
import com.flytrap.venusplanner.api.study_plan.presentation.dto.request.StudyPlanCreateRequest;
import com.flytrap.venusplanner.api.study_plan.presentation.dto.response.StudyPlanReadResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudyPlanFacadeService {

    private final StudyService studyService;
    private final PlanCategoryService planCategoryService;
    private final PlanService planService;

    @Transactional(readOnly = false)
    public Long savePlan(Long studyId, StudyPlanCreateRequest request) {
        Study study = studyService.findById(studyId);
        PlanCategory planCategory = planCategoryService.findById(request.categoryId());
        return planService.savePlan(study, planCategory, request);
    }

    public List<StudyPlanReadResponse> findAllByStudyId(Long studyId) {
        Study study = studyService.findById(studyId);
        List<Plan> plans = planService.findAllByStudyId(studyId);

        return StudyPlanReadResponse.from(plans);
    }
}
