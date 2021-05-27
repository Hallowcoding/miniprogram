package com.hallowcoder.sell.dto;

import lombok.Data;

/**
 * CartDTO
 *
 * @author th
 * 2019/6/21 17:49
 **/
@Data
public class CartDTO {

    /** 商品Id. */
    private String productId;

    /** 商品数量 */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
