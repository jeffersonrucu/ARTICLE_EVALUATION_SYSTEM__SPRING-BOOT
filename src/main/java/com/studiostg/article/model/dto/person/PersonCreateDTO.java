package com.studiostg.article.model.dto.person;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PersonCreateDTO (
        @NotNull
        @NotBlank
        String name,

        @NotNull
        @NotBlank
        String gender

) {}