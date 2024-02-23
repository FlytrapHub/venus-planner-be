package com.flytrap.venusplanner.api.plan.domain;

import com.flytrap.venusplanner.api.study.domain.PlanCategory;
import com.flytrap.venusplanner.api.study.domain.Study;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_id", nullable = false)
    private Study study;

    @ManyToOne
    @JoinColumn(name = "plan_category_id")
    private PlanCategory planCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recurring_option_id")
    private RecurringOption recurringOption;

    private String title; // Null 이면 default: 새로운 일정
    private String description;

    @NotNull
    private Instant start_time;

    @NotNull
    private Instant end_time;

    private Instant notification_time;
}
