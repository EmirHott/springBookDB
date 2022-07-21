package com.springBookDB.springBookDB.bean.book.publisher.service;

import com.springBookDB.springBookDB.bean.book.publisher.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    PublisherRepository publisherRepository;


    public Publisher savePublisher (Publisher publisher){
        return publisherRepository.save(publisher);
    }

    public void removePublisher (Publisher publisher){
        publisherRepository.delete(publisher);
    }

    public List<Publisher> getAllPublisher(){
        return publisherRepository.findAll();
    }

    public Publisher findById (Integer publisherId){
        return publisherRepository.getReferenceById(publisherId);
    }
    public Publisher findPublisherByLastId (){
        return publisherRepository.findPublisherByLastId();
    }
    public Publisher findByName (String publisherName){
        return publisherRepository.findByPublisherName(publisherName);
    }
}
