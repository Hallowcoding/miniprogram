package com.hallowcoder.sell.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * ProductInfo
 *
 * 商品
 * @Author th
 * 2019/6/20 2:58
 **/
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 商品价格 */
    private BigDecimal productPrice;

    /** 商品库存 */
    private Integer productStock;

    /** 商品描述 */
    private String productDescription;

    /** 商品小图 */
    private String productIcon;

    /** 商品状态, 0正常1下架 */
    private Integer productStatus;

    /** 商品类型 */
    private Integer categoryType;
}
