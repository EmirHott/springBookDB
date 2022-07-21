package com.springBookDB.springBookDB.bean.user.note.service;


import com.springBookDB.springBookDB.bean.user.entity.User;
import com.springBookDB.springBookDB.bean.user.note.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public Note saveNote (Note note){
        return noteRepository.save(note);
    }

    public void removeNote (Note note){
        noteRepository.delete(note);
    }

    public List<Note> getAllNote(){
        return noteRepository.findAll();
    }

    public Note findById (Integer noteId){
        return noteRepository.getReferenceById(noteId);
    }

    public Note findNoteByLastId (){
        return noteRepository.findNoteByLastId();
    }

    public List<Note> findByUserId (User user) {
        return  noteRepository.findNotesByUserId(user);
    }
    public Note findByTitle (String title){
        return noteRepository.findNoteByNoteTitle(title);
    }
}
