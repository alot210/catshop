package businesslogic.managedbeans;
import businesslogic.manager.ArticleManager;
import transferModels.Article;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean
public class ArticleBean implements Serializable{

    private Article article;
    private ArticleManager articleManager;

    void init(){

        articleManager = new ArticleManager();
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

    public String getArticles(){

        articleManager.getArticles();
        return "products.xhtml";
    }




}
