package models.submodels;

import play.i18n.Messages;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>Перечисление типов Оплат и Поставок</p>
 *
 * @author Dmitriy Grigoriev
 */
public enum SupplyPaymentType {
  /**
   * Поставка
   */
  SUPPLY(Messages.get("supply")),
  /**
   * Оплата
   */
  PAYMENT(Messages.get("payment"));

  private String caption;

  SupplyPaymentType(String caption) {
    this.caption = caption;
  }

  public String caption() {
    return caption;
  }

  public static Map<String, String> options() {
    LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
    for (SupplyPaymentType type : values()) {
      options.put(type.name(), type.caption());
    }
    return options;
  }
}
