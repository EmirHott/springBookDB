package com.springBookDB.springBookDB.bean.book.author.entity;

import com.springBookDB.springBookDB.bean.book.entity.Book;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "authors")
public class Author implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "author_id")
    private Integer authorId;

    @Basic(optional = false)
    @Column(name = "author_name")
    private String authorName;

    @Basic(optional = false)
    @Column(name = "author_surname")
    private String authorSurname;


    @ManyToMany(mappedBy = "authorList")
    private List<Book> bookList;

    public Author() {
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(authorId, author.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId);
    }

    @Override
    public String toString() {
        return authorName + "" + authorSurname;
    }
}
