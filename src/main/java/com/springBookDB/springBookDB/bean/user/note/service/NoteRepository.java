package com.springBookDB.springBookDB.bean.user.note.service;

import com.springBookDB.springBookDB.bean.user.entity.User;
import com.springBookDB.springBookDB.bean.user.note.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Integer> {


    @Query(value = ("SELECT * FROM notes WHERE note_id order by note_id DESC LIMIT 1"), nativeQuery = true)
    Note findNoteByLastId();

    List<Note> findNotesByUserId(User userId);

    Note findNoteByNoteTitle(String title);
}

