package com.flytrap.venusplanner.api.plan.domain;

import com.flytrap.venusplanner.api.plan.business.service.EndOptionCalculate;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
            ZonedDateTime zdtStart = startDate.atZone(ZoneId.systemDefault());
            ZonedDateTime zdtEnd = zdtStart.plusMonths(count - 1);
            return zdtEnd.toInstant();
        }

        @Override
        public int calculateCount(Instant startDate, Instant endDate) {
            ZonedDateTime zdtStart = startDate.atZone(ZoneId.systemDefault());
            ZonedDateTime zdtEnd = endDate.atZone(ZoneId.systemDefault());
            long monthsBetween = ChronoUnit.MONTHS.between(zdtStart, zdtEnd);
            return (int) monthsBetween + 1;
        }
    },
    YEARLY {
        @Override
        public Instant calculateEndDate(Instant startDate, int count) {
            ZonedDateTime zdtStart = startDate.atZone(ZoneId.systemDefault());
            ZonedDateTime zdtEnd = zdtStart.plusYears(count - 1);
            return zdtEnd.toInstant();
        }

        @Override
        public int calculateCount(Instant startDate, Instant endDate) {
            ZonedDateTime zdtStart = startDate.atZone(ZoneId.systemDefault());
            ZonedDateTime zdtEnd = endDate.atZone(ZoneId.systemDefault());
            long yearsBetween = ChronoUnit.YEARS.between(zdtStart, zdtEnd);
            return (int) yearsBetween + 1;
        }
    };
}
