package com.hallowcoder.sell.service;

import com.hallowcoder.sell.entity.ProductCategory;

import java.util.List;

/**
 * CategoryService
 *
 * @Author th
 * @Date 2019/6/20
 * @Time 2:30
 **/
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
