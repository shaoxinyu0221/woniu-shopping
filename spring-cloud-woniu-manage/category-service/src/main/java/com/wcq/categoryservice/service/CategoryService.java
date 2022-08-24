package com.wcq.categoryservice.service;

import com.wcq.categoryservice.dao.mysql.po.CategoryPo;

public interface CategoryService {

    Integer addCategoryRoot(CategoryPo categoryPo);
}
