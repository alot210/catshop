package businesslogic.managedbeans;
import businesslogic.manager.ArticleManager;
import transferModels.Article;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "articleBean")
@SessionScoped
public class ArticleBean implements Serializable{

    private Article article;
    private ArticleManager articleManager;
    public List<Article> articleList;
    private String search;

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
        articleList = articleManager.getArticles();
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

    public String getSearch() { return search; }

    public void setSearch(String search) { this.search = search; }

    /*public List<Article> getArticles(){

        articleList = articleManager.getArticles();
        return articleList;
//        return "products.xhtml";
    }*/

    public List<Article> getArticleList(){

        //System.out.println("getArticleList-method");
        //articleList = articleManager.getArticles();


        return articleList;
    }

    public void searchListener(AjaxBehaviorEvent e){

        System.out.println("searchListener");
        Article a = new Article();
        if(search!=null && !search.equals("")) {
            a.setName(search);

            try {
                articleList = articleManager.getArticles(a);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }else{
            articleList=articleManager.getArticles();
        }
        System.out.println(articleList.toString());


    }




}
