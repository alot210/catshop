package businesslogic;

import transferModels.Article;
import transferModels.ShoppingCart;

import java.util.List;

public class ShoppingCartManager {

    //TODO
    private ShoppingCart shoppingCart;

    public void checkout(ShoppingCart cart){

    }

    public int calculate(ShoppingCart shoppingCart){
        return 0;
    }

    public ShoppingCart createShoppingCart(){
        return this.shoppingCart = new ShoppingCart();
    }

    public ShoppingCart createShoppingCart(List<Article> articleList){
        return this.shoppingCart = new ShoppingCart(articleList);
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    void addArticle(ShoppingCart shoppingCart, int articleID){
    }


    void deleteArticle(ShoppingCart shoppingCart, int articleID){
    }
}
