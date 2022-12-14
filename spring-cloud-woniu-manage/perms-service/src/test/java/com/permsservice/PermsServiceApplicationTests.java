package com.permsservice;

import com.permsservice.dao.mysql.PermsMysqlDao;
import com.permsservice.dao.po.RbacPermsPo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Transactional
class PermsServiceApplicationTests {

    @Resource
    private PermsMysqlDao permsMysqlDao;

    @Test
    void contextLoads() {
        List<RbacPermsPo> parentPerms = permsMysqlDao.findParentPermsByUserId(1);
        for (RbacPermsPo perm : parentPerms) {
            System.out.println(perm.getPercode());
        }
    }

}
