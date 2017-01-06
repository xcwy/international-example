package io.international.model;

import lombok.Data;

import java.util.List;

/**
 * Created by Davis on 17/1/6.
 */
@Data
public class InternationalModel {
  CurrencyModel defaultCurrency;

  List<CurrencyModel> supportCurrencies;

  LanguageModel defaultLanguage;

  List<LanguageModel> supportLanguages;
}
