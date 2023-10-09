package com.studiostg.article.model.dto.person;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PersonUpdateDTO(
        @NotNull
        Long id,

        String name,

        String gender
) {}