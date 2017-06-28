package controllers;


import play.mvc.*;

import views.html.*;

import com.avaje.ebean.Model;

import models.Product;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class StoreController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    
    public Result getAllStores() {
        java.util.List<models.Store> stores = new com.avaje.ebean.Model.Finder(String.class, models.Store.class).all();
        return ok(play.libs.Json.toJson(stores));
    }

    public Result getStoreById(String storeid) {
        return redirect(routes.HomeController.index());

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
