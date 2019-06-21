package com.hallowcoder.sell.exception;

import com.hallowcoder.sell.enums.ResultEnum;

/**
 * SellException
 *
 * @author th
 * 2019/6/21 16:55
 **/
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }
}
