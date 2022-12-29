package com.globallogic.library.repositories;

import com.globallogic.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
   List<Book> findByBookTitleContainingAndRatingsAndPublishingYear(String bookTitle, double ratings, int publishingYear);
}
