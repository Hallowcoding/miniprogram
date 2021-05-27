package com.hallowcoder.idiom.service.impl;

import com.hallowcoder.idiom.model.Level;
import com.hallowcoder.idiom.model.LevelDetail;
import com.hallowcoder.idiom.repository.LevelRepository;
import com.hallowcoder.idiom.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanghao
 * @date 2021/5/22 17:28
 */
@Service
public class LevelServiceImpl implements LevelService {
  @Autowired
  private LevelRepository levelRepository;

  @Override
  public List<Level> list() {
    return levelRepository.findAll(Sort.by(Sort.Order.asc("id")));
  }

  @Override
  public Level getLevel(Long levelId) {
    return levelRepository.getById(levelId);
  }

  @Override
  public List<LevelDetail> getLevelDetail(Long levelId) {
    return levelRepository.findDetailByLevelId(levelId);
  }

  @Override
  public Long getUserLevelId(String userId) {
    Long levelId = levelRepository.findLevelIdByUserId(userId);
    return null == levelId? 0L : levelId;
  }
}
