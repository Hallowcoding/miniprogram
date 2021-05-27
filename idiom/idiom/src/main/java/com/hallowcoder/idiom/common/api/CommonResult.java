package com.hallowcoder.idiom.common.api;

import lombok.Data;

/**
 * 通用返回对象
 * @author tanghao
 * @date 2021/5/22 17:56
 */
@Data
public class CommonResult<T> {
  private long code;
  private String message;
  private T data;

  protected CommonResult() {
  }

  protected CommonResult(long code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  /**
   * 成功返回结果
   *
   * @param data 获取的数据
   */
  public static <T> CommonResult<T> success(T data) {
    return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
  }

  /**
   * 成功返回结果
   *
   * @param data 获取的数据
   * @param  message 提示信息
   */
  public static <T> CommonResult<T> success(T data, String message) {
    return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
  }

  /**
   * 失败返回结果
   * @param message 提示信息
   */
  public static <T> CommonResult<T> failed(String message) {
    return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
  }

}
