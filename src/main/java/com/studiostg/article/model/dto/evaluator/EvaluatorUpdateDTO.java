package com.studiostg.article.model.dto.evaluator;

import com.studiostg.article.model.bean.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EvaluatorUpdateDTO(
        @NotNull
        @NotBlank
        Long id,
        Person person
) {}
