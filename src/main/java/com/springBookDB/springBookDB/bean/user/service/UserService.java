package com.springBookDB.springBookDB.bean.user.service;

import com.springBookDB.springBookDB.bean.book.entity.Book;
import com.springBookDB.springBookDB.bean.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser (User user){
        return userRepository.save(user);
    }

    public void removeUser (User user){
        userRepository.delete(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User findById (Integer userId){
        return userRepository.getReferenceById(userId);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findUserByLastId(){
        return userRepository.findUserByLastId();
    }
}
