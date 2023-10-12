package com.studiostg.article.model.dto.evaluator;

import com.studiostg.article.model.bean.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EvaluatorCreateDTO(
        @NotNull
        Long id_person
) {}
