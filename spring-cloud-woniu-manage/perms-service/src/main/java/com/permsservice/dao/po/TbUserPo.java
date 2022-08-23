package com.permsservice.dao.po;

import lombok.Getter;
import lombok.Setter;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/22 19:55
 */
@Entity
@Getter
@Setter
@Table(name = "tb_user", schema = "woniu-shopping")
public class TbUserPo implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "created")
    private Timestamp created;
    @Basic
    @Column(name = "salt")
    private String salt;

//    @ManyToMany
//    @JoinTable(name = "rbac_user_perm",
//            joinColumns = {@JoinColumn(name = "userid",referencedColumnName = "id")},
//            inverseJoinColumns ={@JoinColumn(name = "permid",referencedColumnName = "id")}
//    )
    @Transient
    private List<RbacPermsPo> permsPoList;
}
