package com.flytrap.venusplanner.api.plan_category.business.service;

import com.flytrap.venusplanner.api.plan_category.domain.PlanCategory;
import com.flytrap.venusplanner.api.plan_category.infrastructure.repository.PlanCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlanCategoryService {

    private final PlanCategoryRepository planCategoryRepository;

    public PlanCategory findById(Long id) {
        //TODO: optional null일 때 에러처리
        return planCategoryRepository.findById(id).get();
    }
}
