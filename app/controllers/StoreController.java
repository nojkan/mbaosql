package controllers;


import play.mvc.*;

import views.html.*;

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
        java.util.List<models.Store> stores = new play.db.ebean.Model.Finder(String.class, models.Store.class).all();
        return ok(play.libs.Json.toJson(stores);
    }

    public Result getStoreById(String storeid) {
        return ok(index.render("Your new application is ready."));
    }


    public Result postStore() {
        return ok(index.render("Your new application is ready."));
    }

    public Result deleteStoreById(String storeid) {
        return ok(index.render("Your new application is ready."));
    }
    public Result updateStoreById(String storeid) {
        return ok(index.render("Your new application is ready."));
    }


}
