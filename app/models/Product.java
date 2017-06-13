package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;


import com.avaje.ebean.*;


/**
 * Product entity managed by Ebean
 */
@Entity 
public class Product extends Model {



    @Id
    public String refproduct;

    @Constraints.Required
    public String name;

    public String picture;

    @Formats.DateTime(pattern="yyyy-MM-dd")
    public timestamp creationdate;

    
    /**
     * Generic query helper for entity Product with refproduct string
     */
    public static Model.Finder<String,Product> find = new Model.Finder<String,Product>(String.class, Product.class);

    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Product c: Product.find.orderBy("name").findList()) {
            options.put(c.id.toString(), c.name);
        }
        return options;
    }

}
