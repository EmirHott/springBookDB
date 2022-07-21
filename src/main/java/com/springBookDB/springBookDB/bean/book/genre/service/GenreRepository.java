package com.springBookDB.springBookDB.bean.book.genre.service;

import com.springBookDB.springBookDB.bean.book.genre.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Integer> {

    @Query(value = ("SELECT * FROM genres WHERE genre_id order by genre_id DESC LIMIT 1"), nativeQuery = true)
    Genre findGenreByLastId ();

    Genre findByGenreName (String genreName);

    List<Genre> findGenresByGenreName (String genreName);
}
