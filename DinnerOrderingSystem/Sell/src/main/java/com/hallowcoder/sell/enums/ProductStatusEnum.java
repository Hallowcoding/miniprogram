package com.hallowcoder.sell.enums;

import lombok.Getter;

/**
 * ProductStatusEnum
 *
 * 商品状态
 * @Author th
 * @Date 2019/6/20
 * @Time 3:42
 **/
@Getter
public enum ProductStatusEnum {

    UP(0, "在架"),
    DOWN(1, "下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
