package businesslogic.manager;

import data.H2ArticleDao;
import data.H2FactoryDao;
import transferModels.Article;

import java.sql.SQLException;
import java.util.List;

public class ArticleManager {

    public void createArticle(Article article){

        //System.out.println("aMan mit createAr wird aufgerufen");
        Article _article = new Article(article.getId(), article.getName(), article.getPrice(), article.getAmount(), article.getImage());
        H2ArticleDao articleDao = H2FactoryDao.getDaoArticle();
        try {
            articleDao.addArticle(_article);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createArticleTable(){
        H2ArticleDao articleDao = H2FactoryDao.getDaoArticle();
        articleDao.createArticleTable();
    }

    public List<Article> getArticles(){

        H2ArticleDao articleDao = H2FactoryDao.getDaoArticle();
        return articleDao.getArticleList();
    }

    public List<Article> getArticles(Article a) throws SQLException {

        H2ArticleDao articleDao = H2FactoryDao.getDaoArticle();
        return articleDao.getArticles(a);
    }


}
