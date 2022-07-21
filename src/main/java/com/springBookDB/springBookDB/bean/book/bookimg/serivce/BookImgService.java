package com.springBookDB.springBookDB.bean.book.bookimg.serivce;

import com.springBookDB.springBookDB.bean.book.bookimg.entity.BookImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookImgService {

    @Autowired
    BookImgRepository bookImgRepository;

    public BookImg saveBookImg (BookImg bookImg){
        return bookImgRepository.save(bookImg);
    }

    public void removeBookImg (BookImg bookImg){
        bookImgRepository.delete(bookImg);
    }

    public List<BookImg> getAllBookImg(){
        return bookImgRepository.findAll();
    }

    public BookImg findById (Integer bookImgId){
        return bookImgRepository.getReferenceById(bookImgId);
    }

    public BookImg findByName (String bookImgName){
        return bookImgRepository.findByBookImgName(bookImgName);}
    
}
