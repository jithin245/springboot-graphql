package com.globallogic.library.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class BookInput {
    @NotBlank(message = "Book title is missing")
    private String bookTitle;
    private int publishingYear;
    private double ratings;
    private double price;
    private int authorId;
}
