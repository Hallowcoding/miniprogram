package com.hallowcoder.sell.enums;

import lombok.Getter;

/**
 * ResultEnum
 *
 * @author th
 * 2019/6/21 16:56
 **/
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10, "商品不存在"),

    PRODUCT_NOT_ENOUGH_STOCK(11, "库存不足"),

    ORDER_NOT_EXIST(12, "订单不存在"),

    ORDERDETAIL_NOT_EXIST(13, "订单详情不存在"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
