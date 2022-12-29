package com.globallogic.library.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "authors")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "author name shouldn't blank")
    private String authorName;
    private int age;
    private int numberOfBooksWritten;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author(int id) {
        this.id = id;
    }
}
