package controllers;


import play.mvc.*;

import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ProductController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result getAllProducts() {
        java.util.List<models.Product> products = new play.db.ebean.Model.Finder(String.class, models.Product.class).all();
        return ok(play.libs.Json.toJson(products);
    }
    

    public Result getProductById(String productid) {
        return ok(index.render("Your new application is ready."));
    }


    public Result postProduct() {
        return ok(index.render("Your new application is ready."));
    }

    public Result deleteProductById(String productid) {
          Product.find.ref(productid).delete();

        return ok(""+productId+" deleted");
    }
    public Result updateProductById(String productid) {
        return ok(index.render("Your new application is ready."));
    }


}
