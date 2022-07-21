package com.springBookDB.springBookDB.bean.book.service;

import com.springBookDB.springBookDB.bean.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void removeBook(Book book) {
        bookRepository.delete(book);
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public Book findById(Integer bookId) {
        return bookRepository.getReferenceById(bookId);
    }

    public Book findBookByLastId() {
        return bookRepository.findBookByLastId();

    }
    public List<Book> findFourBooks(){
        return bookRepository.findFourBooks();
    }

    public List<Book> findBookThatContainsInTitle(String text){
        return bookRepository.findBookThatContainsInTitle(text);
    }
    public Book findByName (String bookTitle){
        return bookRepository.findByBookTitle(bookTitle);
    }

}
