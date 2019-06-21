package com.hallowcoder.sell.service;

import com.hallowcoder.sell.dto.CartDTO;
import com.hallowcoder.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * ProductService
 *
 * 商品
 * @author th
 * 2019/6/20 3:33
 **/
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表
     * @return 在架商品列表
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**
     * 添加库存
     */
    void increaseStock(List<CartDTO> cartDTOList);


    /**
     * 扣减库存
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
