package com.globallogic.library.controllers;

import com.globallogic.library.entities.Book;
import com.globallogic.library.exceptions.BookNotFoundException;
import com.globallogic.library.model.BookInput;
import com.globallogic.library.services.BookService;
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
public class TestBookController {

        @InjectMocks
        private BookController bookController;
        @Mock
        private BookService bookService;

        @Test
        public void testCreate(){

            BookInput bookInput = BookInput.builder()
                    .bookTitle("Harry Porter")
                    .publishingYear(2000)
                    .price(45)
                    .build();
            Book book = Book.builder()
                    .bookTitle(bookInput.getBookTitle())
                    .publishingYear(bookInput.getPublishingYear())
                    .price(bookInput.getPrice())
                    .ratings(bookInput.getRatings())
                    .id(1)
                    .build();
            Mockito.when(bookService.create(Mockito.any()))
                    .thenReturn(book);
            Assert.assertEquals(1, bookController.create(bookInput).getId());

        }
        @Test
        public void testGet() throws BookNotFoundException {

            BookInput bookInput = BookInput.builder()
                    .bookTitle("Harry Porter")
                    .publishingYear(1990)
                    .price(45)
                    .ratings(4.5)
                    .build();
            Book book = Book.builder()
                    .bookTitle(bookInput.getBookTitle())
                    .publishingYear(bookInput.getPublishingYear())
                    .price(bookInput.getPrice())
                    .ratings(bookInput.getRatings())
                    .id(1)
                    .build();
            Mockito.when(bookService.get(1))
                    .thenReturn(book);
            Assert.assertEquals(book, bookController.get(1));

        }
        @Test
        public void testGetAll(){

            BookInput bookInput = BookInput.builder()
                    .bookTitle("Harry Porter")
                    .publishingYear(1990)
                    .price(45.0)
                    .ratings(4.5)
                    .build();
            Book book1 = Book.builder()
                    .bookTitle(bookInput.getBookTitle())
                    .publishingYear(bookInput.getPublishingYear())
                    .price(bookInput.getPrice())
                    .ratings(bookInput.getRatings())
                    .id(1)
                    .build();
            Book book2 = Book.builder()
                    .bookTitle(bookInput.getBookTitle())
                    .publishingYear(bookInput.getPublishingYear())
                    .price(bookInput.getPrice())
                    .ratings(bookInput.getRatings())
                    .id(1)
                    .build();
            List<Book> books = new ArrayList<>();
            books.add(book1);
            books.add(book2);
            Mockito.when(bookService.getAll())
                    .thenReturn(books);
            Assert.assertEquals(2, bookController.getAll().size());

        }


    }


