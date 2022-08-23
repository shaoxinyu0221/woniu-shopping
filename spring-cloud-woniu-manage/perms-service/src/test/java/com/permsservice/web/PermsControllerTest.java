package com.permsservice.web;

import com.permsservice.dao.mysql.PermsMysqlDao;
import com.permsservice.dao.po.RbacPermsPo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PermsControllerTest {

    @Resource
    private PermsMysqlDao permsMysqlDao;
    @Resource
    private PermsController permsController;
    @Test
    void setSonCode() {
        List<RbacPermsPo> parentPerms = permsMysqlDao.findParentPermsByUserId(1);
        System.out.println(parentPerms.size());
        for (RbacPermsPo parentPerm : parentPerms) {
            permsController.setSonCode(parentPerm);
        }
        for (RbacPermsPo parentPerm : parentPerms) {
            System.out.println(parentPerm);
        }

    }
}