package com.springBookDB.springBookDB.bean.user.note.status.service;

import com.springBookDB.springBookDB.bean.user.note.status.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status,Integer> {
}
