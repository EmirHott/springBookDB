package com.springBookDB.springBookDB.bean.user.service;

import com.springBookDB.springBookDB.bean.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @Query(value = "SELECT * FROM user WHERE user_id order by user_id DESC LIMIT 1", nativeQuery = true)
    User findUserByLastId ();
}
