package com.flytrap.venusplanner.api.study.presentation.controller;

import com.flytrap.venusplanner.api.study.business.service.StudyService;
import com.flytrap.venusplanner.api.study.domain.Study;
import com.flytrap.venusplanner.api.study.presentation.dto.StudyCreateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;

    @PostMapping("/api/v1/studies")
    public ResponseEntity<StudyCreateDto.Response> createStudy(
            @Valid @RequestBody StudyCreateDto.Request request
    ) {
        Study study = studyService.saveStudy(request.toEntity());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(StudyCreateDto.Response.from(study));
    }
}
