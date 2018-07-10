package businesslogic.manager;

import data.H2ArticleDao;
import data.H2FactoryDao;
import transferModels.Article;
import transferModels.ShoppingCart;

import java.sql.SQLException;
import java.util.List;

public class ShoppingCartManager {

    private ShoppingCart shoppingCart;


    public ShoppingCart createShoppingCart(){
        return this.shoppingCart = new ShoppingCart();
    }

    public ShoppingCart createShoppingCart(List<Article> articleList){
        return this.shoppingCart = new ShoppingCart(articleList);
    }

    public void checkout(ShoppingCart cart) {
        H2ArticleDao articleDao = H2FactoryDao.getDaoArticle();
        List<Article> articlesInCart = shoppingCart.getArticleList();
        for (Article a : articlesInCart) {
            try {
                articleDao.reduceAmount(a.getAmount(), a.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        shoppingCart.resetCart();
    }

    public int calculate(ShoppingCart shoppingCart){
       List<Article> articlesInCart = shoppingCart.getArticleList();
       int sum = 0;
       for(Article a : articlesInCart){
          sum += a.getPrice() * a.getAmount();
       }
       shoppingCart.setSum(sum);
       return shoppingCart.getSum();
    }


    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void addArticle(ShoppingCart shoppingCart, String articleID){
        H2ArticleDao articleDao = H2FactoryDao.getDaoArticle();
        try {
            shoppingCart.getArticleList().add(articleDao.getArticle(articleID));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteArticle(ShoppingCart shoppingCart, String articleID) {
        H2ArticleDao articleDao = H2FactoryDao.getDaoArticle();
        try {
            shoppingCart.getArticleList().remove( articleDao.getArticle(articleID));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Article> getArticles(){
        return shoppingCart.getArticleList();
    }
}
