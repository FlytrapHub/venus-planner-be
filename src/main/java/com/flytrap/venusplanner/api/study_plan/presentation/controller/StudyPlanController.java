package com.flytrap.venusplanner.api.study_plan.presentation.controller;

import com.flytrap.venusplanner.api.study_plan.business.service.StudyPlanFacadeService;
import com.flytrap.venusplanner.api.study_plan.presentation.dto.request.StudyPlanCreateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudyPlanController {

    private final StudyPlanFacadeService studyPlanFacadeService;

    @PostMapping("/api/v1/studies/{studyId}/plans")
    public ResponseEntity<Long> createPlan(@PathVariable("studyId") Long studyId,
                                           @Valid @RequestBody StudyPlanCreateRequest request) {
        Long memberId = 1L;
        Long planId = studyPlanFacadeService.savePlan(studyId, request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(planId);
    }
}
