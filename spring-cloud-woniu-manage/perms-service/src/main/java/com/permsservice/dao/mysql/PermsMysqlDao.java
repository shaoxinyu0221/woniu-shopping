package com.permsservice.dao.mysql;

import com.permsservice.dao.po.RbacPermsPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/22 20:02
 */
@Repository
public interface PermsMysqlDao extends JpaRepository<RbacPermsPo,Integer>, JpaSpecificationExecutor<RbacPermsPo> {

    @Query("select rpp from TbUserPo user,RbacPermsPo rpp,RbacUserPermPo rupp where user.id=rupp.userid and rpp.id=rupp.permid and rpp.parentid is null and user.id=?1")
    List<RbacPermsPo> findParentPermsByUserId(Integer userId);


    List<RbacPermsPo> findAllByParentid(Integer parentId);

}
