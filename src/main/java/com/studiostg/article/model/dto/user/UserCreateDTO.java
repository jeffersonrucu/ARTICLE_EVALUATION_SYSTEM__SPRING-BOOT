package com.studiostg.article.model.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.studiostg.article.model.bean.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserCreateDTO(
        @NotNull
        @NotBlank
        String username,
        @NotNull
        @NotBlank
        String password,
        @NotNull
        int permission,
        @NotNull
        boolean inactive,
        @NotNull
        Person person
){ }
