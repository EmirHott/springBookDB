package com.springBookDB.springBookDB.bean.user.privilege.service;

import com.springBookDB.springBookDB.bean.user.privilege.entity.Privilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivilegeService {

    @Autowired
    PrivilegeRepository privilegeRepository;

    public Privilege savePrivilege (Privilege privilege){
        return privilegeRepository.save(privilege);
    }

    public void removePrivilege (Privilege privilege){
        privilegeRepository.delete(privilege);
    }
    public List<Privilege> getAllPrivilege (){
        return privilegeRepository.findAll();
    }
    public  Privilege findById(Integer privilegeId){
        return privilegeRepository.getReferenceById(privilegeId);
    }

}
