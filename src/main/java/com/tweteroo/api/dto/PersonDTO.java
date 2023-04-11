package com.tweteroo.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PersonDTO(

    @NotBlank
    String username, 

    @Pattern(regexp = "^https?://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$", message = "Invalid URL")
    String avatar) {
}
