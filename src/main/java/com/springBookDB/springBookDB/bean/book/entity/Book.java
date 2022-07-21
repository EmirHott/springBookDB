package com.springBookDB.springBookDB.bean.book.entity;

import com.springBookDB.springBookDB.bean.book.author.entity.Author;
import com.springBookDB.springBookDB.bean.book.bookimg.entity.BookImg;
import com.springBookDB.springBookDB.bean.book.genre.entity.Genre;
import com.springBookDB.springBookDB.bean.book.publisher.entity.Publisher;
import com.springBookDB.springBookDB.bean.user.note.entity.Note;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "book_id")
    private Integer bookId;

    @Basic(optional = false)
    @Column(name = "book_title")
    private String bookTitle;

    @Basic(optional = false)
    @Column(name = "book_pagenumber")
    private Integer bookPages;

    @Basic(optional = false)
    @Column(name = "book_publication_date")
    private LocalDate bookPublicationDate;

    @Basic(optional = true)
    @Column(name = "book_rating")
    private BigDecimal bookRating;

    @JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id")
    @ManyToOne
    private Publisher publisherId;

    @JoinColumn (name = "book_img_id", referencedColumnName = "books_img_id")
    @ManyToOne
    private BookImg bookImgId;

    @Basic(optional = true)
    @Column(name = "book_info")
    private String bookInfo;

    @OneToMany(mappedBy = "bookId")
    private List<Note> noteList;

    @JoinTable (name = "book_genre", joinColumns = {
            @JoinColumn(name = "book_id", referencedColumnName = "book_id")},
            inverseJoinColumns = {
            @JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
            })
    @ManyToMany()
    private List<Genre> genreList;

    @JoinTable(name = "books_authors", joinColumns = {
            @JoinColumn(name = "book_id", referencedColumnName = "book_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
            })
    @ManyToMany()
    private List<Author> authorList;

    public Book() {
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Integer getBookPages() {
        return bookPages;
    }

    public void setBookPages(Integer bookPages) {
        this.bookPages = bookPages;
    }

    public LocalDate getBookPublicationDate() {
        return bookPublicationDate;
    }

    public void setBookPublicationDate(LocalDate bookPublicationDate) {
        this.bookPublicationDate = bookPublicationDate;
    }

    public BigDecimal getBookRating() {
        return bookRating;
    }

    public void setBookRating(BigDecimal bookRating) {
        this.bookRating = bookRating;
    }

    public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
    }

    public BookImg getBookImgId() {
        return bookImgId;
    }

    public void setBookImgId(BookImg bookImgId) {
        this.bookImgId = bookImgId;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }

    @Override
    public String toString() {
        return bookTitle;
    }
}
