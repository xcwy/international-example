package io.international.service;

import io.international.entity.Currency;
import io.international.entity.International;
import io.international.model.CurrencyMap;
import io.international.model.CurrencyModel;
import io.international.model.InternationalModel;
import io.international.model.mapper.CurrencyMapper;
import io.international.model.mapper.InternationalMapper;
import io.international.repository.InternationalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Davis on 17/1/6.
 */
@Service
public class InternationalService {
  @Autowired
  private InternationalRepository repository;

  public InternationalModel setDefaultCurrency(String currencyCode) {

    CurrencyModel currencyModel = CurrencyMap.getCurrencyByCode(currencyCode);
    if (currencyModel == null) {
      throw new RuntimeException("can not find currency by code : " + currencyCode);
    }

    Currency defaultCurrency = CurrencyMapper.modelToEntity(currencyModel);

    International international = getInternational();

    international.setDefaultCurrency(defaultCurrency);

    List<Currency> supportCurrencies = international.getSupportCurrencies();

    if (!supportCurrencies.contains(defaultCurrency)) {
      supportCurrencies.add(defaultCurrency);
    }

    international.setSupportCurrencies(supportCurrencies);

    International savedInternational = repository.save(international);

    return InternationalMapper.entityToModel(savedInternational);
  }

  public International getInternational() {
    List<International> internationalList = repository.findAll();
    return internationalList.parallelStream().findAny().orElse(new International());
  }
}
