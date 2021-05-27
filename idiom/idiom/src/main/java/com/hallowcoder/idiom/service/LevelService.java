package com.hallowcoder.idiom.service;

import com.hallowcoder.idiom.model.Level;
import com.hallowcoder.idiom.model.LevelDetail;

import java.util.List;

/**
 * 关卡service
 * @author tanghao
 * @date 2021/5/22 17:26
 */
public interface LevelService {
  /**
   * 查询所有关卡
   * @return
   */
  List<Level> list();

  /**
   * 查询单个关卡
   * @param levelId
   * @return
   */
  Level getLevel(Long levelId);

  /**
   * 查询关卡详情
   * @param levelId
   * @return
   */
  List<LevelDetail> getLevelDetail(Long levelId);

  /**
   * 查询用户通过的最大关卡id
   * @param userId 用户id
   * @return
   */
  Long getUserLevelId(String userId);
}
