package com.hallowcoder.idiom.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author tanghao
 * @date 2021/5/22 16:58
 */
@Entity(name = "level_detail")
@Data
public class LevelDetail implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private Long levelId;

  private Integer row;

  private Integer column;

  private String value;

  private Integer vor;

  private Long idiomId;
}
