package com.hallowcoder.sell.service;

import com.hallowcoder.sell.dto.OrderDTO;

/**
 * BuyerService
 *
 * 买家
 * @author th
 * 2019/6/22 14:33
 **/
public interface BuyerService {

    /**
     * 查询一个订单
     * @param openid 微信用户openid
     * @param orderId 要查询的订单id
     * @return
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     * @param openid 微信用户openid
     * @param orderId 要取消的订单id
     * @return
     */
    OrderDTO cancelOrder(String openid, String orderId);
}
