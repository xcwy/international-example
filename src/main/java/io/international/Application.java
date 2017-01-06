package io.international;

import io.international.model.CurrencyMap;

/**
 * Created by Davis on 17/1/6.
 */
public class Application {
  public static void main(String[] args) {
    System.out.println(CurrencyMap.getAllCurrencies().size());
    System.out.println(CurrencyMap.isLegalCurrency("USD"));
    System.out.println(CurrencyMap.getCurrencyByCode("USD"));
  }
}
