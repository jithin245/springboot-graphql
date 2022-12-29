package com.globallogic.library.services.impl;

import com.globallogic.library.entities.Author;
import com.globallogic.library.exceptions.AuthorNotFoundException;
import com.globallogic.library.repositories.AuthorRepository;
import com.globallogic.library.services.AuthorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private static Logger logger = LogManager.getLogger(AuthorServiceImpl.class);
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(Author author) {
        logger.info("[AUTHORSVC] savings author details {} ", author.getAuthorName());
        return this.authorRepository.save(author);
    }

    @Override
    public List<Author> getAll() {
        logger.info("[AUTHORSVC] getting all author details ");
        return this.authorRepository.findAll();
    }

    @Override
    public Author get(int authorId) throws AuthorNotFoundException {
        logger.info("[AUTHORSVC] fetching author details {} ", authorId);
        Optional<Author> optionalAuthor = this.authorRepository.findById(authorId);
        if (!optionalAuthor.isPresent()) {
            throw new AuthorNotFoundException("Author you are looking for not found on server !! " + authorId);
        }
        return optionalAuthor.get();
    }

}
