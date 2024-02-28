package com.flytrap.venusplanner.api.plan_category.presentation.controller;

import com.flytrap.venusplanner.api.plan_category.business.service.PlanCategoryService;
import com.flytrap.venusplanner.api.plan_category.domain.PlanCategory;
import com.flytrap.venusplanner.api.plan_category.presentation.dto.request.PlanCategoryCreateRequest;
import com.flytrap.venusplanner.api.plan_category.presentation.dto.response.PlanCategoryReadResponse;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/api/v1/studies/{studyId}/categories")
    public ResponseEntity<List<PlanCategoryReadResponse>> readPlanCategories(
            @PathVariable("studyId") Long studyId
    ) {
        List<PlanCategory> planCategories = planCategoryService.findAllByStudyId(studyId);

        return ResponseEntity.ok()
                .body(PlanCategoryReadResponse.from(planCategories));
    }
}
