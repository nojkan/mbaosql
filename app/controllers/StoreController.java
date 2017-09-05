package controllers;


import play.mvc.*;
import services.*;

import views.html.*;
import com.avaje.ebean.Model;
import models.Store;

import play.libs.Json;  
import play.libs.Json.*;    

import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.node.ArrayNode;
import javax.inject.Inject;

import play.db.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class StoreController extends Controller {


    private static Database db;
    
    @Inject
    public StoreController(Database db){
        this.db = db;
    }


    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    
    public Result getAllStores(Integer limit, Integer offset) {

        java.util.List<models.Store> stores;

     
        if (limit != null && offset != null){
            
            stores = new com.avaje.ebean.Model.Finder(String.class, models.Store.class).setMaxRows(limit).setFirstRow(offset).findList();
            //stores = new com.avaje.ebean.Model.Finder(String.class, models.Store.class).findPagedList(offset.intValue(),limit.intValue());
        
        } else {
            stores = new com.avaje.ebean.Model.Finder(String.class, models.Store.class).all();
        }
        return ok(play.libs.Json.toJson(stores));
    }

    public Result getStoreById(String storeid) {

        System.out.println("getStoreById");
         try {
        String sstore = StoreService.selectStoreByID(db, storeid);
        return ok(sstore);
        //TODO Add Content type Application/Json
    
        } catch (java.sql.SQLException sqle){
            System.out.println(sqle.getMessage());
            return internalServerError(""+sqle.getMessage());
        } 

    }

    public Result getAllStoresInJson(Integer limit, Integer offset){
        try {
            JsonNode sstore = StoreService.selectAllStoreJSON(db, limit, offset);
            return ok(sstore);
        } catch (java.sql.SQLException sqle){
            System.out.println(sqle.getMessage());
            return internalServerError(""+sqle.getMessage());
        }
    }


    public Result postStore() {
        return redirect(routes.HomeController.index());

    }

    public Result deleteStoreById(String storeid) {
        return redirect(routes.HomeController.index());

    }
    public Result updateStoreById(String storeid) {
       return redirect(routes.HomeController.index());

    }


}
