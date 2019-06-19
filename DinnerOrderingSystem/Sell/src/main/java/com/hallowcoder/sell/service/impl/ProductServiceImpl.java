package com.hallowcoder.sell.service.impl;

import com.hallowcoder.sell.dao.ProductInfoDao;
import com.hallowcoder.sell.entity.ProductInfo;
import com.hallowcoder.sell.enums.ProductStatusEnum;
import com.hallowcoder.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductServiceImpl
 *
 * @Author th
 * @Date 2019/6/20
 * @Time 3:37
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao dao;

    @Override
    public ProductInfo findOne(String productId) {
        return dao.getOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return dao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return dao.save(productInfo);
    }
}
