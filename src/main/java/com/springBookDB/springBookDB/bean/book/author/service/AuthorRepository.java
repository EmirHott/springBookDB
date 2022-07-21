package com.springBookDB.springBookDB.bean.book.author.service;

import com.springBookDB.springBookDB.bean.book.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

    @Query(value = "SELECT * FROM authors WHERE author_id order by author_id DESC LIMIT 1", nativeQuery = true)
    Author findAuthorByLastId ();

    Author findByAuthorName (String authorName);

    List<Author> findAuthorsByAuthorName (String authorName);
}
