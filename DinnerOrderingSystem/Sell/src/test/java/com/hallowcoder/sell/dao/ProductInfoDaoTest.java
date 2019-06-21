package com.hallowcoder.sell.dao;

import com.hallowcoder.sell.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * ProductInfoDaoTest
 *
 * @Author th
 * @Date 2019/6/20
 * @Time 3:07
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao dao;

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123");
        productInfo.setProductName("葱油拌面");
        productInfo.setProductPrice(new BigDecimal(6));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("面食");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(3);

        ProductInfo result = dao.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {

        List<ProductInfo> productInfoList = dao.findByProductStatus(0);
        Assert.assertNotEquals(0, productInfoList.size());
    }
}