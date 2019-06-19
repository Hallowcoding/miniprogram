package com.hallowcoder.sell.dao;

import com.hallowcoder.sell.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ProductInfoDao
 *
 * @Author th
 * @Date 2019/6/20
 * @Time 3:04
 **/
public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
