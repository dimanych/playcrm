package models.submodels;

import play.i18n.Messages;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>Перечисление поставок</p>
 *
 * @author Dmitriy Grigoriev
 */
public enum SupplyState {
  /**
   * Планируется
   */
  PLANNED(Messages.get("info.planned")),
  /**
   * Ожидание поставки
   */
  WAITING(Messages.get("info.supply.waiting")),
  /**
   * Частично поставлен
   */
  PARTIALLY(Messages.get("info.supply.partially")),
  /**
   * Поставлен полностью
   */
  COMPLETED(Messages.get("info.supply.completed")),
  /**
   * Отменено
   */
  CANCELED(Messages.get("info.canceled"));

  private String caption;

  SupplyState(String caption) {
    this.caption = caption;
  }

  public String caption() {
    return caption;
  }

  public static Map<String, String> options() {
    LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
    for (SupplyState orderState : values()) {
      options.put(orderState.name(), orderState.caption());
    }
    return options;
  }
}
