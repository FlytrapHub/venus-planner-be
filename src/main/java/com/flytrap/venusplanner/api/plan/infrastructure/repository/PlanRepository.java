package com.flytrap.venusplanner.api.plan.infrastructure.repository;

import com.flytrap.venusplanner.api.plan.domain.Plan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findAllByStudyId(Long studyId);
}
