package com.globallogic.library.services.impl;

import com.globallogic.library.entities.Book;
import com.globallogic.library.exceptions.BookNotFoundException;
import com.globallogic.library.repositories.BookRepository;
import com.globallogic.library.services.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private static Logger logger = LogManager.getLogger(BookServiceImpl.class);

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(Book book) {
        logger.info("[BOOKSVC] saving book details {} ", book.getBookTitle());
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        try {
            logger.info("[BOOKSVC] fetching all book details");
            return this.bookRepository.findAll();
        } catch (Exception e) {
            logger.error("[BOOKSVC] error while fetching all books", e);
        }
        return Collections.emptyList();
    }

    @Override
    public Book get(int bookId) throws BookNotFoundException {
        logger.info("[BOOKSVC] fetching book details of {} ", bookId);
        Optional<Book> optionalBook = Optional.empty();
        try {
            optionalBook = this.bookRepository.findById(bookId);
        } catch (Exception e) {
            logger.error("[BOOKSVC] error while fetching book id {} ", bookId, e);
        }

        if (!optionalBook.isPresent()) {
            throw new BookNotFoundException("Book you are looking for not found on server !!" + bookId);
        }
        return optionalBook.get();
    }

    public List<Book> getBookByTitleRatingsAndPublishingYear(String bookTitle,double ratings, int publishingYear) {
        try {
            logger.info("[BOOKSVC] fetching book details of {} {} {} ", bookTitle, ratings, publishingYear);
            return this.bookRepository.findByBookTitleContainingAndRatingsAndPublishingYear(bookTitle,ratings,publishingYear);
        } catch (Exception e) {
            logger.error("[BOOKSVC] error while fetching book details {} {} {} ", bookTitle, ratings, publishingYear, e);
        }
        return Collections.emptyList();
    }
}
