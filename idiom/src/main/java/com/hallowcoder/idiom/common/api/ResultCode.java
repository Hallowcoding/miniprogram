package com.hallowcoder.idiom.common.api;

import lombok.Getter;

/**
 * @author tanghao
 * @date 2021/5/22 17:57
 */
@Getter
public enum ResultCode {
  SUCCESS(200, "操作成功"),
  FAILED(500, "操作失败"),
  VALIDATE_FAILED(404, "参数检验失败"),
  UNAUTHORIZED(401, "暂未登录或token已经过期"),
  FORBIDDEN(403, "没有相关权限");
  private long code;
  private String message;

  private ResultCode(long code, String message) {
    this.code = code;
    this.message = message;
  }
}
