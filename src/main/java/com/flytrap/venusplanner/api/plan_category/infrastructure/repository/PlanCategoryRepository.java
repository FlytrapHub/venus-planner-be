package com.flytrap.venusplanner.api.plan_category.infrastructure.repository;

import com.flytrap.venusplanner.api.plan_category.domain.PlanCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanCategoryRepository extends JpaRepository<PlanCategory, Long> {
}
