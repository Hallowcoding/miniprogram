package com.hallowcoder.idiom.dto;

import lombok.Data;

import java.util.Map;
import java.util.Set;

/**
 * @author tanghao
 * @date 2021/5/26 11:14
 */
@Data
public class LevelDetailResult {
  /**关卡id*/
  private Long levelId;
  /**关卡内容*/
  private Map[][] words;
  /**关卡填写选项*/
  private Set<String> answers;
}
