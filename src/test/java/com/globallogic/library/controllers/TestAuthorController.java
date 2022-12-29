package com.globallogic.library.controllers;

import com.globallogic.library.entities.Author;
import com.globallogic.library.exceptions.AuthorNotFoundException;
import com.globallogic.library.model.AuthorInput;
import com.globallogic.library.services.AuthorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestAuthorController {

    @InjectMocks
    private AuthorController authorController;
    @Mock
    private AuthorService authorService;

    @Test
    public void testCreate(){

        AuthorInput authorInput = AuthorInput.builder()
                .numberOfBooksWritten(5)
                .authorName("J.K Rowling")
                .age(45)
                .build();
        Author author = Author.builder()
                .numberOfBooksWritten(authorInput.getNumberOfBooksWritten())
                .authorName(authorInput.getAuthorName())
                .age(authorInput.getAge())
                .id(1)
                .build();
        Mockito.when(authorService.create(Mockito.any()))
                .thenReturn(author);
        Assert.assertEquals(1, authorController.create(authorInput).getId());

    }
    @Test
    public void testGet() throws AuthorNotFoundException {

        AuthorInput authorInput = AuthorInput.builder()
                .numberOfBooksWritten(5)
                .authorName("J.K Rowling")
                .age(45)
                .build();
        Author author = Author.builder()
                .numberOfBooksWritten(authorInput.getNumberOfBooksWritten())
                .authorName(authorInput.getAuthorName())
                .age(authorInput.getAge())
                .id(1)
                .build();
        Mockito.when(authorService.get(1))
                .thenReturn(author);
        Assert.assertEquals(author, authorController.get(1));

    }
    @Test
    public void testGetAll(){

        AuthorInput authorInput = AuthorInput.builder()
                .numberOfBooksWritten(5)
                .authorName("J.K Rowling")
                .age(45)
                .build();
        Author author1 = Author.builder()
                .numberOfBooksWritten(authorInput.getNumberOfBooksWritten())
                .authorName(authorInput.getAuthorName())
                .age(authorInput.getAge())
                .id(1)
                .build();
        Author author2 = Author.builder()
                .numberOfBooksWritten(authorInput.getNumberOfBooksWritten())
                .authorName(authorInput.getAuthorName())
                .age(authorInput.getAge())
                .id(1)
                .build();
        List<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);
        Mockito.when(authorService.getAll())
                .thenReturn(authors);
        Assert.assertEquals(2, authorController.getAll().size());

    }


}
