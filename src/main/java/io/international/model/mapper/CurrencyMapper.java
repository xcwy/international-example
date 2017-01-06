package io.international.model.mapper;

import io.international.entity.Currency;
import io.international.model.CurrencyModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Davis on 17/1/6.
 */
public final class CurrencyMapper {
  private CurrencyMapper() {
  }

  public static Currency modelToEntity(CurrencyModel model) {
    Currency entity = new Currency();

    entity.setCurrencyCode(model.getCurrencyCode());
    entity.setName(model.getName());
    entity.setConversionFactor(model.getConversionFactor());

    return entity;
  }

  public static CurrencyModel entityToModel(Currency entity) {
    CurrencyModel model = new CurrencyModel();

    model.setCurrencyCode(entity.getCurrencyCode());
    model.setName(entity.getName());
    model.setConversionFactor(entity.getConversionFactor());

    return model;
  }

  public static List<CurrencyModel> entityToModel(List<Currency> entities) {
    return entities.parallelStream().map(
        entity -> {
          return entityToModel(entity);
        }
    ).collect(Collectors.toList());
  }
}
