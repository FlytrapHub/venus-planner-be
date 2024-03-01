package com.flytrap.venusplanner.acceptance.plan_category;

import static com.flytrap.venusplanner.global.step.PlanCategoryStep.일정_카테고리_생성_요청;
import static org.assertj.core.api.Assertions.assertThat;

import com.flytrap.venusplanner.global.AcceptanceTest;
import com.flytrap.venusplanner.global.fixture.PlanCategoryFixture;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

@DisplayName("[인수테스트] Plan Category CRUD 성공")
class PlanCategoryTest extends AcceptanceTest {

    @Test
    void 일정_카테고리_생성_요청_시_성공한다() {
        // given
        // TODO: 로그인 요청

        // when
        var response = 일정_카테고리_생성_요청(
                1L,
                PlanCategoryFixture.모임.toDto()
        );

        // then
        일정_카테고리_생성_정보_검증(response);
        응답_상태코드_검증(response, HttpStatus.CREATED);
    }

    private void 일정_카테고리_생성_정보_검증(ExtractableResponse<Response> response) {
        PlanCategoryCreateDto.Response actual = response.jsonPath()
                .getObject(".", PlanCategoryCreateDto.Response.class);
        Long expected = 1L;

        assertThat(actual).hasFieldOrPropertyWithValue("planCategoryId", expected);
    }
}
