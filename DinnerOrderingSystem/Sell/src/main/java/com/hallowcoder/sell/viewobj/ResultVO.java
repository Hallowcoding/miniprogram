package com.hallowcoder.sell.viewobj;

import lombok.Data;

/**
 * ResultVO
 *
 * http请求返回最外层对象
 * @author th
 * @date 2019/6/20 11:07
 **/
@Data
public class ResultVO<T> {

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体内容 */
    private T data;
}
