package com.springBookDB.springBookDB.bean.book.service;

import com.springBookDB.springBookDB.bean.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

      @Query(value = "SELECT * FROM books WHERE book_id order by book_id DESC LIMIT 1", nativeQuery = true)
      Book findBookByLastId();

      @Query(value = ("SELECT * FROM books LIMIT 4"), nativeQuery = true )
      List<Book> findFourBooks();

      @Query("SELECT b FROM Book b WHERE b.bookTitle LIKE concat('%',:text,'%')" )
      List<Book> findBookThatContainsInTitle(String text);

      Book findByBookTitle (String bookTitle);

}
