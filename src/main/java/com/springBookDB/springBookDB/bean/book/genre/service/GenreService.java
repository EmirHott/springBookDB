package com.springBookDB.springBookDB.bean.book.genre.service;

import com.springBookDB.springBookDB.bean.book.genre.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;


    public Genre saveGenre (Genre genre){
        return genreRepository.save(genre);
    }

    public void removeGenre (Genre genre){
        genreRepository.delete(genre);
    }

    public List<Genre> getAllUGenre(){
        return genreRepository.findAll();
    }

    public Genre findById (Integer genreId){
        return genreRepository.getReferenceById(genreId);
    }

    public Genre findGenreByLastId (){
        return genreRepository.findGenreByLastId();
    }

    public Genre findByName (String genreName){
        return genreRepository.findByGenreName(genreName);
    }

    public List<Genre> findGenresByGenreName (String genreName){
        return genreRepository.findGenresByGenreName(genreName);
    }

}
