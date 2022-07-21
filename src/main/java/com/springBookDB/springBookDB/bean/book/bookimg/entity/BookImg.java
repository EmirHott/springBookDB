package com.springBookDB.springBookDB.bean.book.bookimg.entity;

import com.springBookDB.springBookDB.bean.book.entity.Book;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "books_img")
public class BookImg implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "books_img_id")
    private Integer bookImgId;
    @Column(name = "book_img")
    private String imgPath;

    @Column(name ="book_img_name")
    private String bookImgName;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "bookImgId")
    private List<Book> bookList;

    public BookImg() {
    }

    public Integer getBookImgId() {
        return bookImgId;
    }

    public void setBookImgId(Integer bookImgId) {
        this.bookImgId = bookImgId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getBookImgName() {
        return bookImgName;
    }

    public void setBookImgName(String bookImgName) {
        this.bookImgName = bookImgName;
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
        BookImg bookImg = (BookImg) o;
        return Objects.equals(bookImgId, bookImg.bookImgId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookImgId);
    }

    @Override
    public String toString() {
        return bookImgName;
    }
}
