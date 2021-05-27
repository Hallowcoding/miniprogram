package com.hallowcoder.idiom.controller;

import com.hallowcoder.idiom.dto.LevelDetailResult;
import com.hallowcoder.idiom.model.Level;
import com.hallowcoder.idiom.model.LevelDetail;
import com.hallowcoder.idiom.service.LevelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tanghao
 * @date 2021/5/26 11:36
 */
@SpringBootTest
class LevelControllerTest {

  @Autowired
  private LevelController levelController;

  @Test
  void list() {
  }

  @Test
  @Transactional
  void detail() {
    System.out.println(levelController.detail(1L, ""));
  }
}