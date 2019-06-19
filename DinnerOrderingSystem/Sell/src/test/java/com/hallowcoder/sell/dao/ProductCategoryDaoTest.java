package com.hallowcoder.sell.dao;

import com.hallowcoder.sell.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ProductCategoryDaoTest
 *
 * @author th
 * @date 2019/6/19 0:48
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao dao;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = dao.getOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("主食类");
        productCategory.setCategoryType(3);
        dao.save(productCategory);
    }
}