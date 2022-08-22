package com.permsservice.dao.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
public class TbUserPo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
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

    @ManyToMany()
    private List<RbacPermsPo> permsPoList;
}
