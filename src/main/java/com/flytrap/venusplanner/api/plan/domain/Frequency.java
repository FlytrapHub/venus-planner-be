package com.flytrap.venusplanner.api.plan.domain;

import com.flytrap.venusplanner.api.plan.business.service.EndOptionCalculate;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public enum Frequency implements EndOptionCalculate {
    WEEKLY {
        @Override
        public Instant calculateEndDate(Instant startDate, int count) {
            return startDate.plus((count - 1) * 7, ChronoUnit.DAYS);
        }

        @Override
        public int calculateCount(Instant startDate, Instant endDate) {
            long weeksBetween = ChronoUnit.WEEKS.between(startDate, endDate);
            return (int) weeksBetween + 1;
        }
    },
    MONTHLY {
        @Override
        public Instant calculateEndDate(Instant startDate, int count) {
            return startDate.plus(count - 1, ChronoUnit.MONTHS);
        }

        @Override
        public int calculateCount(Instant startDate, Instant endDate) {
            long monthsBetween = ChronoUnit.MONTHS.between(startDate, endDate);
            return (int) monthsBetween + 1;
        }
    },
    YEARLY {
        @Override
        public Instant calculateEndDate(Instant startDate, int count) {
            return startDate.plus(count - 1, ChronoUnit.YEARS);
        }

        @Override
        public int calculateCount(Instant startDate, Instant endDate) {
            long yearsBetween = ChronoUnit.YEARS.between(startDate, endDate);
            return (int) yearsBetween + 1;
        }
    };
}
