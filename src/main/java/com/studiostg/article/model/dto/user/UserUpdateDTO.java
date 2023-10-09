package com.studiostg.article.model.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.studiostg.article.model.bean.Person;
import jakarta.validation.constraints.NotNull;

public record UserUpdateDTO(
        @NotNull
        Long id,

        String username,

        String password,

        Integer permission,

        Boolean inactive,

        Person person
){
}
