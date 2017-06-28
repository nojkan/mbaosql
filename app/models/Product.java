package models;

import java.util.*;
import javax.persistence.*;
import javax.persistence.Column;

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
    @Column(name="refproduct")
    public String refproduct;

  
    @Column(name="name")
    public String name;

    @Column(name="picture")
    public String picture;

    @Formats.DateTime(pattern="yyyy-MM-dd")
    @Column(name="creationdate")
    public Date creationdate;

    @Column(name="stock")
    public String stock;


    public String getRef(){
        return refproduct;
    }

    public void setRef(String ref){
        this.refproduct = ref;
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

    public Date getCreationDate(){
        return creationdate;
    }
    

    public void setCreationDate(Date creationdate){
        this.creationdate = creationdate;
    }

    public String getStock(){
        return stock;
    }

    public void setStock(String stock){
        this.stock = stock;
    }

    /**
     * Generic query helper for entity Product with refproduct string
     */
    public static Model.Finder<String,Product> find = new Model.Finder<String,Product>(String.class, Product.class);

    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Product c: Product.find.orderBy("name").findList()) {
            options.put(c.refproduct.toString(), c.name);
        }
        return options;
    }

}
