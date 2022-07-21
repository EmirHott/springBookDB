package com.springBookDB.springBookDB.bean.book.bookimg.serivce;

import com.springBookDB.springBookDB.bean.book.bookimg.entity.BookImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookImgRepository extends JpaRepository<BookImg,Integer> {

    BookImg findByBookImgName (String bookImgName);
}
