package com.hallowcoder.sell.dao;

import com.hallowcoder.sell.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * OrderMasterDaoTest
 *
 * @author th
 * 2019/6/21 15:31
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    private OrderMasterDao dao;

    private final String OPENID = "hallow";

    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("654321");
        orderMaster.setBuyerName("hallow");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setBuyerPhone("17512075782");
        orderMaster.setBuyerAddress("深圳市宝安区");
        orderMaster.setOrderAmount(new BigDecimal(9.9));

        OrderMaster result = dao.save(orderMaster);

        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = PageRequest.of(0, 3);

        Page<OrderMaster> orderMasterPage = dao.findByBuyerOpenid(OPENID, pageRequest);
        Assert.assertNotEquals(0, orderMasterPage.getTotalElements());
    }
}