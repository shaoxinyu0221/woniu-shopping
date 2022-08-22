package com.permsservice.dao.mysql;

import com.permsservice.dao.po.RbacPermsPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/22 20:02
 */
@Repository
public interface PermsMysqlDao extends JpaRepository<RbacPermsPo,Integer>, JpaSpecificationExecutor<RbacPermsPo> {
}
