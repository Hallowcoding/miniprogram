package com.hallowcoder.idiom.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author tanghao
 * @date 2021/5/22 17:32
 */
@Entity(name = "level_user")
@Data
public class LevelUser implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String userId;

  private Long levelId;
}
