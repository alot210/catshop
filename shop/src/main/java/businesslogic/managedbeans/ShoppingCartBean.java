package businesslogic.managedbeans;

import businesslogic.manager.ShoppingCartManager;
import transferModels.Article;
import transferModels.ShoppingCart;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name="shoppingCartBean")
@SessionScoped
public class ShoppingCartBean implements Serializable {

    private ShoppingCart shoppingCart;
    private ShoppingCartManager shoppingCartManager;

    @PostConstruct
    void init(){
        //TEST
        setShoppingCart(new ShoppingCart(new ArrayList<Article>()));
        setShoppingCartManager(new ShoppingCartManager());
        this.shoppingCartManager.addArticle(this.shoppingCart, 1);

    }

    public void setShoppingCart(ShoppingCart shoppingCart){
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public ShoppingCartManager getShoppingCartManager() {
        return shoppingCartManager;
    }

    public void setShoppingCartManager(ShoppingCartManager shoppingCartManager) {
        this.shoppingCartManager = shoppingCartManager;
    }


    public int getTotalSum(){
       return shoppingCartManager.calculate(shoppingCart);
    }

    //button action= viewCart -> shoppingcart.xhtml
    public String viewCart(){

        System.out.print("test");
       /*->nullpointerexception wenn shopcartmanager noch nicht existiert
       if(shoppingCartManager.getArticles() == null){
           //"ist leer"
       }*/
       return "shoppingcart.xhtml";
    }

    //button action=add -> shoppingcart.xhtml
    public String add(int articleID){
        shoppingCartManager.addArticle(shoppingCart, articleID);
        return "pages/shoppingcart.xhtml";
    }

    //button action=delete -> shoppingcart.xhtml
    public String delete(int articleID){
        shoppingCartManager.deleteArticle(shoppingCart, articleID);
        return "pages/shoppingcart.xhtml";
    }

    //button action=calculate -> shoppingcart.xhtml
    public String calculate(){
        shoppingCartManager.calculate(shoppingCart);
        return "pages/shoppingcart.xhtml";
    }

    //button action=checkout -> checkout.xhtml
    public String checkout(){
        shoppingCartManager.checkout(shoppingCart);
        return "ok";
    }

}
