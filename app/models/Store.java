package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

/**
 * Computer entity managed by Ebean
 */
@Entity 
public class Store extends Model {

    @Id
    public String refstore;
    
    @Constraints.Required
    public String name;

    public String picture;
    
    public int vat;
    public String currency;
    public String merchantkey;

   public String getRef(){
        return refstore;
    }

    public void setRef(String ref){
        this.refstore = ref;
    }
    
      public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

     public String getPicture(){
        return picture;
    }

    public void setPicture(String Picture){
        this.picture = picture;
    }

    public void setVat(int vat){
        this.vat = vat;
    }

    public int getvat(){
        return vat;
    }

    public void setCurrency(String currency){
        this.currency = currency;
    }

    public String getCurrency(){
        return currency;
    } 
     public void setMerchantkey(String merchantkey){
        this.merchantkey = merchantkey;
     }
    
    
   // @ManyToOne
   // public Company company;
    
    /**
     * Generic query helper for entity Computer with id Long
     */
    public static Finder<String,Store> find = new Finder<String,Store>(String.class, Store.class); 



    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Store c: Store.find.orderBy("name").findList()) {
            options.put(c.refstore.toString(), c.name);
        }
        return options;
    }
    
    /**
     * Return a page of computer
     *
     * @param page Page to display
     * @param pageSize Number of computers per page
     * @param sortBy Computer property used for sorting
     * @param order Sort order (either or asc or desc)
     * @param filter Filter applied on the name column
     */
   /*public static Page<Store> page(int page, int pageSize, String sortBy, String order, String filter) {
        return 
            find.where()
                .ilike("name", "%" + filter + "%")
                .orderBy(sortBy + " " + order)
                .fetch("company")
                .findPagingList(pageSize)
                .setFetchAhead(false)
                .getPage(page);
    }*/


    
}
