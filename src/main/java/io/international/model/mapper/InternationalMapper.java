package io.international.model.mapper;

import io.international.entity.International;
import io.international.model.InternationalModel;

/**
 * Created by Davis on 17/1/6.
 */
public final class InternationalMapper {
  public static InternationalModel entityToModel(International entity) {
    InternationalModel model = new InternationalModel();

    model.setDefaultCurrency(CurrencyMapper.entityToModel(entity.getDefaultCurrency()));
    model.setSupportCurrencies(CurrencyMapper.entityToModel(entity.getSupportCurrencies()));

    return model;
  }
}
