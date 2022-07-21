package com.springBookDB.springBookDB.bean.user.privilege.service;

import com.springBookDB.springBookDB.bean.user.privilege.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege,Integer> {
}
