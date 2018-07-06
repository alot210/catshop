package data;

import transferModels.Article;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ArticleDao {

    void addArticle(Article article) throws SQLException;
    Article getArticle(int id) throws SQLException;
    void deleteArticle(Article article);
    void reduceAmount(int amount, int id) throws SQLException;
    ArrayList<Article> getArticle();
    ArrayList<Article> getArticles(Article a) throws SQLException;
}
