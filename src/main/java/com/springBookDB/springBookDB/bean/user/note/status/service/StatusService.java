package com.springBookDB.springBookDB.bean.user.note.status.service;

import com.springBookDB.springBookDB.bean.user.note.status.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    StatusRepository statusRepository;

    public Status saveStatus (Status status){
        return statusRepository.save(status);
    }

    public void removeStatus (Status status){
        statusRepository.delete(status);
    }

    public List<Status> getAllStatus(){
        return statusRepository.findAll();
    }

    public Status findById (Integer statusId){
        return statusRepository.getReferenceById(statusId);
    }

}
