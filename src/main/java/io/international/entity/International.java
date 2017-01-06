package io.international.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Davis on 17/1/6.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "project_international")
public class International {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  protected String id;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Currency defaultCurrency;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Currency> supportCurrencies = new ArrayList<>();
}
