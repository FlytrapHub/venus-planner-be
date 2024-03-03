package com.flytrap.venusplanner.api.study_plan.presentation.dto.request;

import com.flytrap.venusplanner.api.plan.domain.EndOption;
import com.flytrap.venusplanner.api.plan.domain.Frequency;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;

public record RecurringOptionRequest(
        @NotNull
        Frequency frequency,

        @NotNull
        EndOption endOption,
        Integer count,
        Instant endDate
) {
}
