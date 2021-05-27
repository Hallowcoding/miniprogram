package com.hallowcoder.idiom.repository;

import com.hallowcoder.idiom.model.Level;
import com.hallowcoder.idiom.model.LevelDetail;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author tanghao
 * @date 2021/5/22 17:04
 */
public interface LevelRepository extends JpaRepository<Level, Long> {

  /**
   * 根据levelId查询详情
   * @param levelId
   * @return
   */
  @Query("select a from level_detail a where a.levelId = :levelId")
  List<LevelDetail> findDetailByLevelId(@Param("levelId") Long levelId);

  /**
   * 查询当前用户所过关卡
   * @param userId
   * @return
   */
  @Query("select a.levelId from level_user a where a.userId = :userId")
  Long findLevelIdByUserId(@Param("userId") String userId);
}
