package controllers;


import play.mvc.*;
import services.*;

import views.html.*;
import com.avaje.ebean.Model;
import models.Product;


import play.libs.Json;  
import play.libs.Json.*;    

import com.fasterxml.jackson.databind.JsonNode;

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
        java.util.List<models.Product> products = new com.avaje.ebean.Model.Finder(String.class, models.Product.class).all();
        return ok(play.libs.Json.toJson(products));
    }
    

    public Result getProductById(String productid) {

        return redirect(routes.HomeController.index());

        /*try {
        String sproduct = ProductService.selectProductByID(productid);
        return ok(sproduct);
    
        } catch (java.sql.SQLException sqle){
            System.out.println(sqle.getMessage());
            return ok("sqle.getMessage()");
        } */
        
    }

    public Result addProduct() {
        play.data.Form<models.Product> form = play.data.Form.form(models.Product.class).bindFromRequest();

        if (form.hasErrors()) {
            return badRequest(index.render("hello, world", form));
        }
        else {

        models.Product product = form.get();
        product.save();
        return redirect(routes.HomeController.index());

        }
    }


    public Result deleteProductById(String productid) {
          Product.find.ref(productid).delete();

        return ok(""+productid+" deleted");
    }
    
    public Result updateProductById(String productid) {
        return redirect(routes.HomeController.index());
    }
}