package data;

import transferModels.Article;

import java.util.ArrayList;

public interface ArticleDao {

    void addArticle(Article article);
    Article getArticle(int id);
    ArrayList<Article> getArticles();
    void reduceAmount(int amount, int id);
}
