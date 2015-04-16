package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dmitriy Grigoriev
 */
@Entity
public class Contractor extends BaseModel {
  private ContractorType contractorType;
  private String adress;

  public static Model.Finder<Long, Contractor> find = new Model.Finder<Long, Contractor>(Long.class, Contractor.class);

  public static List<Contractor> findAll() {
    return find.all();
  }

  public static Contractor findById(Long id) {
    return find.byId(id);
  }

  public static Contractor findByName(String name) {
    return find.where().eq("name", name).findUnique();
  }

  public static Map<String,String> list() {
    LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
    for(Contractor c: Contractor.find.orderBy("name").findList()) {
      options.put(String.valueOf(c.getId()), c.getName());
    }
    return options;
  }

  @OneToOne
  public ContractorType getContractorType() {
    return contractorType;
  }

  public void setContractorType(ContractorType contractorType) {
    this.contractorType = contractorType;
  }

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }
}
