package com.hallowcoder.idiom.service.impl;

import com.hallowcoder.idiom.service.LevelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tanghao
 * @date 2021/5/26 10:20
 */
@SpringBootTest
class LevelServiceImplTest {

  @Autowired
  private LevelService levelService;

  @Test
  void list() {
    System.out.println(levelService.list());
  }

  @Test
  void getLevelDetail() {
    System.out.println(levelService.getLevelDetail(1L));
  }

  @Test
  void getUserLevelId() {
  }
}