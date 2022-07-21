package com.springBookDB.springBookDB.bean.user.privilege.entity;

import com.springBookDB.springBookDB.bean.user.entity.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "privilege")
public class Privilege implements Serializable {
    public static final Integer USER_PRIVILEGE = 2;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "privilege_id")
    private Integer privilegeId;

    @Column(name = "privilege_name")
    @Basic(optional = false)
    private String privilegeName;

    @OneToMany(mappedBy = "privilegeId")
    private List<User> userList;

    public Privilege() {
    }

    public Integer getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Privilege privilege = (Privilege) o;
        return Objects.equals(privilegeId, privilege.privilegeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(privilegeId);
    }

    @Override
    public String toString() {
        return privilegeName;
    }
}
