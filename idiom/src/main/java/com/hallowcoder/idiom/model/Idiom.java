package com.hallowcoder.idiom.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author tanghao
 * @date 2021/5/22 17:00
 */
@Entity
@Data
public class Idiom implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String name;

  private String pinyin;

  private String explain;

  private String source;

  private String exampleSentence;

  private String similarWords;

  private String oppositeWords;
}
