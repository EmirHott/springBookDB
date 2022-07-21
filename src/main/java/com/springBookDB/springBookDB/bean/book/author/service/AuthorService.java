package com.springBookDB.springBookDB.bean.book.author.service;

import com.springBookDB.springBookDB.bean.book.author.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author saveAuthor (Author author){
        return authorRepository.save(author);
    }

    public void removeAuthor (Author author){
        authorRepository.delete(author);
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author findById (Integer authorId){
        return authorRepository.getReferenceById(authorId);
    }

    public Author findAuthorByLastId(){
        return authorRepository.findAuthorByLastId();
    }

    public Author findByName(String authorName){return authorRepository.findByAuthorName(authorName);}

    public List<Author> findAuthorsByAuthorName(String authorName){
        return authorRepository.findAuthorsByAuthorName(authorName);
    }
}
