package models;

import play.db.ebean.Model;
import utils.Util;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <p>Сделки</p>
 *
 * @author Dmitriy Grigoriev
 */
@Entity
public class Deal extends BaseModel {

  /**
   * Контрагент
   */
  private Contractor contractor;
  /**
   * Фаза сделки
   */
  private DealPhase dealPhase;
  /**
   * Дата начала сделки
   */
  private Date startDate;
  /**
   * Дата завершения сделки
   */
  private Date endDate;
  /**
   * Бюджет сделки
   */
  private BigDecimal budget;

  public static final Model.Finder<Long, Deal> find = new Model.Finder<Long, Deal>(Long.class, Deal.class);

  public static List<Deal> findAll() {
    return find.all();
  }

  public static Deal findById(Long id) {
    return find.byId(id);
  }

  public static List<Deal> findByContractor(Contractor contractor) {
    return find.where().eq("contractor", contractor).findList();
  }

  public static Integer countDealsByPhase(Long phaseId) {
    return find.where().eq("deal_phase_id", phaseId).findList().size();
  }

  public static Integer activeDealsCount() {
    return find.where().ne("deal_phase_id", Util.CLOSED_DEAL_ID).findList().size();
  }

  public static Integer closedDealsCount() {
    return find.where().eq("deal_phase_id", Util.CLOSED_DEAL_ID).findList().size();
  }

  public String jsStartDate() {
    return Util.jsDate(startDate);
  }

  public String jsEndDate() {
    return Util.jsDate(endDate);
  }

  @OneToOne
  public Contractor getContractor() {
    return contractor;
  }

  public void setContractor(Contractor contractor) {
    this.contractor = contractor;
  }

  @OneToOne
  public DealPhase getDealPhase() {
    return dealPhase;
  }

  public void setDealPhase(DealPhase dealPhase) {
    this.dealPhase = dealPhase;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public BigDecimal getBudget() {
    return budget;
  }

  public void setBudget(BigDecimal budget) {
    this.budget = budget;
  }


  public String budgetf() {
    return Util.getNumberFormatted(getBudget());
  }
}
