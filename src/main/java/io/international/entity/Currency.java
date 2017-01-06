package io.international.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Davis on 17/1/6.
 */
@Data
@EqualsAndHashCode(callSuper = false, of = {"currencyCode", "conversionFactor", "name"})
@Entity
@Table(name = "project_currency")
public class Currency {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  protected String id;

  /**
   * currency code.
   */
  @Column
  private String currencyCode;

  /**
   * conversion factor.
   */
  @Column
  private String conversionFactor;

  /**
   * name.
   */
  @Column
  private String name;
}
