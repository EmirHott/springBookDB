package com.springBookDB.springBookDB.bean.user.note.entity;

import com.springBookDB.springBookDB.bean.book.entity.Book;
import com.springBookDB.springBookDB.bean.user.entity.User;
import com.springBookDB.springBookDB.bean.user.note.status.entity.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "notes")
public class Note implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "note_id")
    private Integer noteId;

    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private User userId;

    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    @ManyToOne
    private Book bookId;

    @Basic(optional = true)
    @Column(name = "note_text")
    private String noteText;

    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    @ManyToOne
    private Status statusId;

    @Basic(optional = false)
    @Column(name = "note_title")
    private String noteTitle;

    public Note() {
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(noteId, note.noteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteId);
    }

    @Override
    public String toString() {
        return  noteTitle;

    }
}
