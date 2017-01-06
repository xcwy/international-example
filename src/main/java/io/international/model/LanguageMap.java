package io.international.model;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Davis on 17/1/6.
 */
public final class LanguageMap {

  private static final LanguageModel ZH = new LanguageModel("zh", "Chinese", "中文");

  private static final LanguageModel HI = new LanguageModel("hi", "Hindi", "हिन्दी, हिंदी");

  private static final LanguageModel ES = new LanguageModel("es", "Spanish", "español");

  private static final LanguageModel EN = new LanguageModel("en", "English", "English");

  private static final LanguageModel AR = new LanguageModel("ar", "Arabic", "العربية");

  private static final LanguageModel PT = new LanguageModel("pt", "Portuguese", "Português");

  private static final LanguageModel BN = new LanguageModel("bn", "Bengali", "বাংলা");

  private static final LanguageModel RU = new LanguageModel("ru", "Russian", "русский язык");

  private static final LanguageModel JA = new LanguageModel("ja", "Japanese", "日本語 (にほんご／にっぽんご)");

  private static final LanguageModel DE = new LanguageModel("de", "German", "Deutsch");

  private static final LanguageModel PA = new LanguageModel("pa", "Panjabi", "ਪੰਜਾਬੀ");

  private static final LanguageModel JV = new LanguageModel("jv", "Javanese", "basa Jawa");

  private static final LanguageModel KO = new LanguageModel("ko", "Korean", "한국어 (韓國語), 조선말 (朝鮮語)");

  private static final LanguageModel VI = new LanguageModel("vi", "Vietnamese", "Tiếng Việt");

  private static final LanguageModel TE = new LanguageModel("te", "Telugu", "తెలుగు");

  private static final LanguageModel MR = new LanguageModel("mr", "Marathi", "मराठी");

  private static final LanguageModel TA = new LanguageModel("ta", "Tamil", "தமிழ்");

  private static final LanguageModel FR = new LanguageModel("fr", "French", "français");

  private static final LanguageModel UR = new LanguageModel("ur", "Urdu", "اردو");

  private static final LanguageModel IT = new LanguageModel("it", "Italian", "Italiano");

  private static final LanguageModel TR = new LanguageModel("tr", "Turkish", "Türkçe");

  private static final LanguageModel FA = new LanguageModel("fa", "Persian", "فارسی");

  private static final LanguageModel GU = new LanguageModel("gu", "Gujarati", "ગુજરાતી");

  private static final LanguageModel PL = new LanguageModel("pl", "Polish", "polski");

  private static final LanguageModel UK = new LanguageModel("uk", "Ukrainian", "українська");

  private static final LanguageModel ML = new LanguageModel("ml", "Malayalam", "മലയാളം");

  private static final LanguageModel KN = new LanguageModel("kn", "Kannada", "ಕನ್ನಡ");

  private static final LanguageModel OR = new LanguageModel("or", "Oriya", "ଓଡ଼ିଆ");

  private static final LanguageModel MY = new LanguageModel("my", "Burmese", "ဗမာစာ");

  private static final LanguageModel TH = new LanguageModel("th", "Thai", "ไทย");

  private static final List<LanguageModel> LANGUAGE_MODELS;

  static {
    LANGUAGE_MODELS = Lists.newArrayList(
        ZH, HI, ES, EN, AR, PT, BN, RU, JA, DE,
        PA, JV, KO, VI, TE, MR, TA, FR, UR, IT,
        TR, FA, GU, PL, UK, ML, KN, OR, MY, TH
    );
  }

  public static boolean isLegalLanguage(String languageCode) {
    boolean result = false;

    Predicate<LanguageModel> predicate = l -> l.getLanguageCode().equals(languageCode);

    result = LANGUAGE_MODELS.parallelStream().anyMatch(predicate);

    return result;
  }

  public static LanguageModel getLanguageByCode(String languageCode) {
    LanguageModel result = null;

    result = LANGUAGE_MODELS.parallelStream().filter(
        languageModel -> languageModel.getLanguageCode().equals(languageCode)
    ).findAny().orElse(null);

    return result;
  }

  public static List<LanguageModel> getAllLanguages() {
    return Lists.newArrayList(LANGUAGE_MODELS);
  }
}
