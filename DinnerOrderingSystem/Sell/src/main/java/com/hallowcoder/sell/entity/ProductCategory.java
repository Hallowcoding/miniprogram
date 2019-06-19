package com.hallowcoder.sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * ProductCategory
 * 类目
 * @author th
 * @date 2019/6/18 23:51
 **/
@Entity
@Proxy(lazy=false)
@DynamicUpdate
@Data
public class ProductCategory {
    /** 类目id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /** 类目名称 */
    private String categoryName;

    /** 类目编号 */
    private Integer categoryType;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

}
