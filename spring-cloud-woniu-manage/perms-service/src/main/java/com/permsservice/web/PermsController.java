package com.permsservice.web;

import com.commons.utils.ResponseResult;
import com.permsservice.dao.mysql.PermsMysqlDao;
import com.permsservice.dao.po.RbacPermsPo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/23 11:26
 */
@RestController
public class PermsController {

    @Resource
    private PermsMysqlDao permsMysqlDao;

    @GetMapping("/perms/list/{userId}")
    public ResponseResult<List<RbacPermsPo>> getPermListByUserId(@PathVariable("userId") Integer userId){
        //拿到所有的父节点
        List<RbacPermsPo> parentPerms = permsMysqlDao.findParentPermsByUserId(userId);
        //根据父节点,为所有子节点赋值
        for (RbacPermsPo parentPerm : parentPerms) {
            setSonCode(parentPerm);
        }
        return new ResponseResult<>(200,"ok",parentPerms);
    }

    public void setSonCode(RbacPermsPo parentCode){
        List<RbacPermsPo> childList = new ArrayList<>();
        Integer parentId = parentCode.getId();
        childList = permsMysqlDao.findAllByParentid(parentId);
        if (childList.size() == 0){
            return;
        }
        parentCode.setPermsList(childList);
        for (RbacPermsPo rbacPermsPo : childList) {
            setSonCode(rbacPermsPo);
        }
    }

}
