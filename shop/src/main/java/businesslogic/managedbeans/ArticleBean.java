package businesslogic.managedbeans;
import businesslogic.manager.ArticleManager;
import transferModels.Article;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "articleBean")
@SessionScoped
public class ArticleBean implements Serializable{

    private Article article;
    private ArticleManager articleManager;
    public List<Article> articleList;

    @PostConstruct
    void init(){

        System.out.println("articleBean-init");
        articleManager = new ArticleManager();
        articleManager.createArticleTable();
        articleList = new ArrayList<Article>();
        String image = "https://placehold.it/150x80?text=IMAGE";
        Article a1 = new Article(1, "Hoodie", 25, 200, image);
        Article a2 = new Article(2, "Shirt", 15, 100, image);
        Article a3 = new Article(3, "Smartphone Case", 10, 100, image);
        articleManager.createArticle(a1);
        articleManager.createArticle(a2);
        articleManager.createArticle(a3);

        //vorerst um artikel in der liste zu haben

        articleList.add(new Article(1, "Hoodie", 25, 200, image));
        articleList.add(new Article(2, "Shirt", 15, 100, image));
    }


    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public ArticleManager getArticleManager() {
        return articleManager;
    }

    public void setArticleManager(ArticleManager articleManager) {
        this.articleManager = articleManager;
    }

    /*public List<Article> getArticles(){

        articleList = articleManager.getArticles();
        return articleList;
//        return "products.xhtml";
    }*/

    public List<Article> getArticleList(){

        System.out.println("getArticleList-method");
        //artikelliste wird gerade noch in der init befüllt, nicht aus der datenbank
        //articleList = articleManager.getArticles();

        return articleList;
    }




}
