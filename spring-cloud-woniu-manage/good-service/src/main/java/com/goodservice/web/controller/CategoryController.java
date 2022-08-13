package com.goodservice.web.controller;

import com.goodservice.dao.mysql.CategoryMysqlDao;
import com.goodservice.web.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 10:19
 */
@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryMysqlDao categoryMysqlDao;


    @GetMapping("/category/list")
    public ResponseEntity<List<CategoryDto>> getCateGoryList(){
        //查找所有父节点
        List<CategoryDto> parentList = categoryMysqlDao.getParentNode();
        //为所有的子节点赋值
        for (CategoryDto parentNode : parentList) {
            setChildrenNode(parentNode);
        }

        return ResponseEntity.ok(parentList);
    }

    public void setChildrenNode(CategoryDto parentNode){

        List<CategoryDto> children = new ArrayList<>();

        Integer parentId = parentNode.getId();

        children = categoryMysqlDao.getListByParentId(parentId);
        if (children.size() == 0){
            return;
        }

        parentNode.setChildren(children);

        for (CategoryDto child : children) {
            setChildrenNode(child);
        }

    }

}
