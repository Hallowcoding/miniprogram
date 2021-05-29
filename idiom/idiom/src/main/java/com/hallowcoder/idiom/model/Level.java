package com.hallowcoder.idiom.model;

import lombok.Data;
import org.hibernate.annotations.Columns;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @author tanghao
 * @date 2021/5/22 16:49
 */
@Entity(name = "level")
@Data
public class Level implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private Integer levelNumber;

  private Integer rows;

  private Integer columns;

  @Transient
  private Integer passOr;
}
