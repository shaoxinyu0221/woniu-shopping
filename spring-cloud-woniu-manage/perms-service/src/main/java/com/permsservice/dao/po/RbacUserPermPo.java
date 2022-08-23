package com.permsservice.dao.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/23 9:22
 */
@Entity
@Table(name = "rbac_user_perm", schema = "woniu-shopping")
public class RbacUserPermPo implements Serializable {

    @Id
    @Basic
    @Column(name = "userid")
    private Integer userid;
    @Basic
    @Column(name = "permid")
    private int permid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getPermid() {
        return permid;
    }

    public void setPermid(int permid) {
        this.permid = permid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RbacUserPermPo that = (RbacUserPermPo) o;
        return userid == that.userid && permid == that.permid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, permid);
    }
}
