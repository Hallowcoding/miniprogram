package com.hallowcoder.idiom.controller;

import com.hallowcoder.idiom.common.api.CommonResult;
import com.hallowcoder.idiom.dto.LevelDetailResult;
import com.hallowcoder.idiom.model.Level;
import com.hallowcoder.idiom.model.LevelDetail;
import com.hallowcoder.idiom.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author tanghao
 * @date 2021/5/26 10:31
 */
@Controller
@RequestMapping("/idiom")
public class LevelController {
  @Autowired
  private LevelService levelService;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  @ResponseBody
  public CommonResult list(@RequestParam(value = "userId") String userId) {
    //用户通过的最大关卡id
    Long levelId = levelService.getUserLevelId(userId);
    List<Level> levelList = levelService.list();
    levelList.stream().forEach(e -> {
      //用户通过的关卡标记为1
      if (levelId >= e.getId()) {
        e.setPassOr(1);
      }
      //用户通过的最大关卡的下一关标记passOr为0
      if (levelId + 1 == e.getId()) {
        e.setPassOr(0);
      }
    });
    return CommonResult.success(levelList);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  @Transactional
  public CommonResult detail(@PathVariable("id") Long levelId, @RequestParam(value = "userId") String userId) {
    //1.关卡：得到最大行列
    Level level = levelService.getLevel(levelId);
    //2.关卡详情：行列中存放的字
    List<LevelDetail> levelDetailList = levelService.getLevelDetail(levelId);
    //3.用户是否通关
    Long userLevelId = levelService.getUserLevelId(userId);

    LevelDetailResult levelDetailResult = new LevelDetailResult();
    Map[][] words = new Map[level.getRows()][level.getColumns()];
    Set<String> answers = new HashSet<>();
    levelDetailList.stream().forEach(e -> {
      Map<String, Object> map = new HashMap<>();
      map.put("v", e.getValue());
      map.put("vor", userLevelId >= levelId? 1 : e.getVor());
      words[e.getRow()][e.getColumn()] = map;
      if (e.getVor() == 0) {
        answers.add(e.getValue());
      }
    });
    if (userLevelId >= levelId) {
      answers.clear();
    }
    levelDetailResult.setLevelId(levelId);
    levelDetailResult.setWords(words);
    levelDetailResult.setAnswers(answers);
    return CommonResult.success(levelDetailResult);
  }
}
