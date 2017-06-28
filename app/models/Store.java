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

   
    public Stock stock;
    
    
    
    
   // @ManyToOne
   // public Company company;
    
    /**
     * Generic query helper for entity Computer with id Long
     */
    public static Finder<String,Store> find = new Finder<String,Store>(String.class, Store.class); 
    
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
