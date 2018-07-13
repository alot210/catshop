package businesslogic.manager;

import data.H2ArticleDao;
import data.H2FactoryDao;
import transferModels.Article;
import transferModels.ShoppingCart;

import java.sql.SQLException;
import java.util.List;

public class ShoppingCartManager {

    private ShoppingCart shoppingCart;


    public ShoppingCart createShoppingCart() {
        return this.shoppingCart = new ShoppingCart();
    }

    public ShoppingCart createShoppingCart(List<Article> articleList) {
        return this.shoppingCart = new ShoppingCart(articleList);
    }

    public List<Article> checkout(ShoppingCart cart) {
        H2ArticleDao articleDao = H2FactoryDao.getDaoArticle();
        List<Article> articlesInCart = cart.getArticleList();
        for (Article a : articlesInCart) {
            try {
                articleDao.reduceAmount(articleDao.getAmount(a), a.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //cart.setArticleList(articleDao.getArticleList());
        cart.resetCart();

        return cart.getArticleList();
    }

    public int calculate(ShoppingCart cart) {

        if (cart.getArticleList() != null) {
            List<Article> articlesInCart = cart.getArticleList();

            int sum = 0;
            for (Article a : articlesInCart) {
                sum += a.getPrice(); // * a.getAmount();
            }

            cart.setSum(sum);
        }
        return cart.getSum();
    }


    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public ShoppingCart addArticle(ShoppingCart cart, String articleID) {
        H2ArticleDao articleDao = H2FactoryDao.getDaoArticle();
        try {
            cart.getArticleList().add(articleDao.getArticle(articleID));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cart;
    }

    public ShoppingCart deleteArticle(ShoppingCart cart, String articleID) {
        H2ArticleDao articleDao = H2FactoryDao.getDaoArticle();

        List<Article> list = cart.getArticleList();
        Article a = null;
        for (Article article : list) {

            if (article.getId() == articleID) {
                a = article;
            }
        }
        list.remove(a);
        cart.setArticleList(list);
        return cart;
    }

    public List<Article> getArticles() {
        return shoppingCart.getArticleList();
    }
}
