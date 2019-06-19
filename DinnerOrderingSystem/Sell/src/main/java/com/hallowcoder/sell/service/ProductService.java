package com.hallowcoder.sell.service;

import com.hallowcoder.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * ProductService
 *
 * 商品
 * @Author th
 * @Date 2019/6/20
 * @Time 3:33
 **/
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //TODO 添加库存

    //TODO 扣减库存
}
