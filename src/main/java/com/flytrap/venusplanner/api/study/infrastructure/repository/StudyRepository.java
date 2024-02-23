package com.flytrap.venusplanner.api.study.infrastructure.repository;

import com.flytrap.venusplanner.api.study.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends JpaRepository<Study, Long> {
}