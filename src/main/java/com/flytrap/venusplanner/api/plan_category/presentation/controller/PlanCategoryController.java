package com.flytrap.venusplanner.api.plan_category.presentation.controller;

import com.flytrap.venusplanner.api.plan_category.business.service.PlanCategoryService;
import com.flytrap.venusplanner.api.plan_category.presentation.dto.request.PlanCategoryCreateRequest;
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
public class PlanCategoryController {

    private final PlanCategoryService planCategoryService;

    @PostMapping("/api/v1/studies/{studyId}/categories")
    public ResponseEntity<Long> createPlanCategory(
            @PathVariable("studyId") Long studyId,
            @Valid @RequestBody PlanCategoryCreateRequest request
    ) {
        Long categoryId = planCategoryService.savePlanCategory(request.toEntity(studyId));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoryId);
    }
}
