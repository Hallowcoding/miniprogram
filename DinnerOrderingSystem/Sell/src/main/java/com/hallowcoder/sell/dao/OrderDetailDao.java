package com.hallowcoder.sell.dao;

import com.hallowcoder.sell.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * OrderDetailDao
 *
 * @author th
 * 2019/6/21 15:24
 **/
public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
