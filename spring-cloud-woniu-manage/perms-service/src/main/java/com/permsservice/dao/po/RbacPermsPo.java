package com.permsservice.dao.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/22 19:54
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "rbac_perms", schema = "woniu-shopping")
public class RbacPermsPo implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "link")
    private String link;
    @Basic
    @Column(name = "parentid")
    private Integer parentid;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "percode")
    private String percode;

    @Transient
    private List<RbacPermsPo> permsList;

}
