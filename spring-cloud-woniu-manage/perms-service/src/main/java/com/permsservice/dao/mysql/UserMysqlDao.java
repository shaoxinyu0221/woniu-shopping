package com.permsservice.dao.mysql;

import com.permsservice.dao.po.TbUserPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/24 19:55
 */
@Repository
public interface UserMysqlDao extends JpaRepository<TbUserPo,Integer> {
}
