package io.international.model;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Davis on 17/1/6.
 */
public final class CurrencyMap {

  private static CurrencyModel USD = new CurrencyModel("USD", "100", "US Dollar");

  private static CurrencyModel EUR = new CurrencyModel("EUR", "100", "Euro");

  private static CurrencyModel GBP = new CurrencyModel("GBP", "100", "British Pound");

  private static CurrencyModel INR = new CurrencyModel("INR", "100", "Indian Rupee");

  private static CurrencyModel AUD = new CurrencyModel("AUD", "100", "Australian Dollar");

  private static CurrencyModel CAD = new CurrencyModel("CAD", "100", "Canadian Dollar");

  private static CurrencyModel SGD = new CurrencyModel("SGD", "100", "Singapore Dollar");

  private static CurrencyModel CHF = new CurrencyModel("CHF", "100", "Swiss Franc");

  private static CurrencyModel MYR = new CurrencyModel("MYR", "100", "Malaysian Ringgit");

  private static CurrencyModel JPY = new CurrencyModel("JPY", "100", "Japanese Yen");

  private static CurrencyModel CNY = new CurrencyModel("CNY", "100", "Chinese yuan");

  private static List<CurrencyModel> currencyModels;

  static {
    currencyModels = Lists.newArrayList(
        USD,
        EUR,
        GBP,
        INR,
        AUD,
        CAD,
        SGD,
        CHF,
        MYR,
        JPY,
        CNY
    );
  }

  /**
   * Gets all currencies.
   *
   * @return the all currencies
   */
  public static List<CurrencyModel> getAllCurrencies() {
    return Lists.newArrayList(currencyModels);
  }

  /**
   * Is legal currency.
   *
   * @param currencyCode the currency code
   * @return the boolean
   */
  public static boolean isLegalCurrency(String currencyCode) {
    boolean result = false;

    Predicate<CurrencyModel> predicate = c -> c.getCurrencyCode().equals(currencyCode);

    result = currencyModels.parallelStream().anyMatch(predicate);

    return result;
  }

  /**
   * Gets currency by code.
   *
   * @param currencyCode the currency code
   * @return the currency by code
   */
  public static CurrencyModel getCurrencyByCode(String currencyCode) {
    CurrencyModel result = null;

    result = currencyModels.parallelStream().filter(
        currencyModel -> currencyModel.getCurrencyCode().equals(currencyCode)
    ).findAny().orElse(null);

    return result;
  }
}
