package com.springBookDB.springBookDB.bean.book.publisher.service;

import com.springBookDB.springBookDB.bean.book.publisher.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

    @Query(value = ("SELECT * FROM publishers WHERE publisher_id order by publisher_id DESC LIMIT 1"), nativeQuery = true)
    Publisher findPublisherByLastId ();

    Publisher findByPublisherName (String publisherName);

}
