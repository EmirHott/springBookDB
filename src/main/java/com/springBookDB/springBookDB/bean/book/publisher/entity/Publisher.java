package com.springBookDB.springBookDB.bean.book.publisher.entity;

import com.springBookDB.springBookDB.bean.book.entity.Book;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "publishers")
public class Publisher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name ="publisher_id")
    private Integer publisherId;

    @Basic(optional = false)
    @Column(name = "publisher_name")
    private String publisherName;

    @OneToMany(mappedBy = "publisherId")
    private List<Book> bookList;

    public Publisher() {
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
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
        Publisher publisher = (Publisher) o;
        return Objects.equals(publisherId, publisher.publisherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherId);
    }

    @Override
    public String toString() {
        return publisherName;
    }
}
