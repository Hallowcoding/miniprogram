package com.hallowcoder.sell.service.impl;

import com.hallowcoder.sell.dto.OrderDTO;
import com.hallowcoder.sell.entity.OrderDetail;
import com.hallowcoder.sell.enums.OrderStatusEnum;
import com.hallowcoder.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * OrderServiceImplTest
 *
 * @author th
 * 2019/6/21 18:25
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "hallow";

    private final String ORDERID = "1561128350103864727";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("hallow");
        orderDTO.setBuyerAddress("上海安亭海友");
        orderDTO.setBuyerPhone("17512075782");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        /** 购物车 */
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("123");
        orderDetail1.setProductQuantity(1);
        orderDetailList.add(orderDetail1);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("456");
        orderDetail2.setProductQuantity(1);
        orderDetailList.add(orderDetail2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);

        log.info("【创建订单】 result = {}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO result = orderService.findOne(ORDERID);
        log.info("【查询单个订单】 result = {}", result);
        Assert.assertNotEquals(ORDERID, result.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, pageRequest);

        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDERID);
        OrderDTO result = orderService.cancel(orderDTO);

        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDERID);
        OrderDTO result = orderService.finish(orderDTO);

        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDERID);
        OrderDTO result = orderService.paid(orderDTO);

        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }
}