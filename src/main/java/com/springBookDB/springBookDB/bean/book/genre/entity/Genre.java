package com.springBookDB.springBookDB.bean.book.genre.entity;

import com.springBookDB.springBookDB.bean.book.entity.Book;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "genres")
public class Genre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "genre_id")
    private Integer genreId;

    @Basic(optional = false)
    @Column(name = "genre_name")
    private String genreName;

    @ManyToMany(mappedBy = "genreList")
    private List<Book> bookList;

    public Genre() {
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
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
        Genre genre = (Genre) o;
        return Objects.equals(genreId, genre.genreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreId);
    }

    @Override
    public String toString() {
        return genreName;
    }
}
