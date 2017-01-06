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

  private static CurrencyModel JPY = new CurrencyModel("JPY", "100", "Japanese Yen");

  private static CurrencyModel GBP = new CurrencyModel("GBP", "100", "British Pound");

  private static CurrencyModel AUD = new CurrencyModel("AUD", "100", "Australian Dollar");

  private static CurrencyModel CHF = new CurrencyModel("CHF", "100", "Swiss Franc");

  private static CurrencyModel CAD = new CurrencyModel("CAD", "100", "Canadian Dollar");

  private static CurrencyModel HKD = new CurrencyModel("HKD", "100", "Hong Kong Dollar");

  private static CurrencyModel SEK = new CurrencyModel("SEK", "100", "Swedish Krona");

  private static CurrencyModel NZD = new CurrencyModel("NZD", "100", "New Zealand Dollar");

  private static CurrencyModel ZAR = new CurrencyModel("ZAR", "100", "South African Rand");

  private static CurrencyModel RUB = new CurrencyModel("RUB", "100", "Russian Ruble");

  private static CurrencyModel INR = new CurrencyModel("INR", "100", "Indian Rupee");

  private static CurrencyModel SGD = new CurrencyModel("SGD", "100", "Singapore Dollar");

  private static CurrencyModel BGN = new CurrencyModel("BGN", "100", "Bulgarian Lev");

  private static CurrencyModel CNY = new CurrencyModel("CNY", "100", "Chinese yuan");

  private static CurrencyModel THB = new CurrencyModel("THB", "100", "Thai Baht");

  private static CurrencyModel HUF = new CurrencyModel("HUF", "100", "Hungarian Forint");

  private static CurrencyModel NOK = new CurrencyModel("NOK", "100", "Norwegian Krone");

  private static CurrencyModel MXN = new CurrencyModel("MXN", "100", "Mexican Peso");

  private static CurrencyModel DKK = new CurrencyModel("DKK", "100", "Danish Krone");

  private static CurrencyModel MYR = new CurrencyModel("MYR", "100", "Malaysian Ringgit");

  private static CurrencyModel PLN = new CurrencyModel("PLN", "100", "Polish Zloty");

  private static CurrencyModel BRL = new CurrencyModel("BRL", "100", "Brazilian Real");

  private static CurrencyModel PHP = new CurrencyModel("PHP", "100", "Philippine Peso");

  private static CurrencyModel IDR = new CurrencyModel("IDR", "100", "Indonesian Rupiah");

  private static CurrencyModel CZK = new CurrencyModel("CZK", "100", "Czech Koruna");

  private static CurrencyModel TWD = new CurrencyModel("TWD", "10", "Taiwan New Dollar");

  private static CurrencyModel KRW = new CurrencyModel("KRW", "100", "South Korean Won");

  private static CurrencyModel CLP = new CurrencyModel("CLP", "100", "Chilean Peso");

  private static List<CurrencyModel> currencyModels;

  static {
    currencyModels = Lists.newArrayList(
        USD, EUR, JPY, GBP, AUD, CHF, CAD, HKD, SEK, NZD,
        ZAR, RUB, INR, SGD, BGN, CNY, THB, HUF, NOK, MXN,
        DKK, MYR, PLN, BRL, PHP, IDR, CZK, TWD, KRW, CLP
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
