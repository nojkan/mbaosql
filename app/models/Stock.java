
package models;

import java.util.*;
import javax.persistence.*;

//import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;


import com.avaje.ebean.*;


/**
 * Product entity managed by Ebean
 */
@Entity 
public class Stock extends Model {


	@OneToOne
	@JoinColumn(name="refstore")
    public Store store;

    @OneToOne
    @JoinColumn(name="refproduct")
    public Product product;
    

    public String status;
    
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date creationdate;

    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date lastupdate;

    public int quantity;
    public int vat;
    public int priceht;

    
    /**
     * Generic query helper for entity Product with refproduct string
     */
    public static Model.Finder<String,Stock> find = new Model.Finder<String,Stock>(String.class, Stock.class);

    

}


