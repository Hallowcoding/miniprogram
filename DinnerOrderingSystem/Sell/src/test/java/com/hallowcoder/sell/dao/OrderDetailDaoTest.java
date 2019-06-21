package com.hallowcoder.sell.dao;

import com.hallowcoder.sell.entity.OrderDetail;
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
 * OrderDetailDaoTest
 *
 * @author th
 * 2019/6/21 16:22
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao dao;

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("222");
        orderDetail.setOrderId("123456");
        orderDetail.setProductId("123");
        orderDetail.setProductName("南瓜粥");
        orderDetail.setProductPrice(new BigDecimal(2));
        orderDetail.setProductQuantity(1);
        orderDetail.setProductIcon("http://xxxx.jpg");

        OrderDetail result = dao.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = dao.findByOrderId("123456");
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}