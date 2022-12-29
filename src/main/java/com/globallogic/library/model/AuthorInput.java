package com.globallogic.library.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class AuthorInput {

    @NotBlank(message = "Author Name missing")
    private String authorName;

    private int age;
    private int numberOfBooksWritten;
}
