package data;

import transferModels.Article;
import transferModels.Config;

import java.sql.*;
import java.util.ArrayList;

public class H2ArticleDao {

    public void addArticle(Article article) throws SQLException {

        //System.out.println("articleDao addarticle wird aufgerufen");
        Connection con = Config.getSQLConnection();

        String sql = "INSERT INTO ARTICLE(ID,NAME,PRICE,AMOUNT) VALUES (?,?,?,?)";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, article.getId());
        statement.setString(2, article.getName());
        statement.setInt(3, article.getPrice());
        statement.setInt(4, article.getAmount());

        int numberRows = statement.executeUpdate();
    }

    public Article getArticle(int id) throws SQLException {
        Connection con = Config.getSQLConnection();
        String sql = "SELECT * FROM ARTICLE WHERE ID="+id;
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Article article = new Article();
        while(resultSet.next()) {
            article.setId(resultSet.getInt("ID"));
            article.setName(resultSet.getString("NAME"));
            article.setPrice(resultSet.getInt("PRICE"));
            article.setAmount(resultSet.getInt("AMOUNT"));
        }
        return article;
    }

    public void deleteArticle(Article article){
        int id = article.getId();
        String sql = "DELETE FROM ARTICLE WHERE ID="+id;
    }

    public void clearTable() throws SQLException {
        Connection con = Config.getSQLConnection();
        PreparedStatement statement = con.prepareStatement("DELETE * FROM ARTICLE");
        statement.execute();
    }


    public void createArticleTable(){


        try {

            System.out.print("artikel tabelle wird erstellt");
            Connection con = Config.getSQLConnection();
            PreparedStatement statement1 = con.prepareStatement("DROP TABLE IF EXISTS ARTICLE");
            PreparedStatement statement2 = con.prepareStatement("CREATE TABLE ARTICLE(ID INT PRIMARY KEY, NAME VARCHAR(255), PRICE INT, AMOUNT INT)");

            statement1.execute();
            statement2.execute();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Article> getArticleList() {

        String sql = "SELECT * FROM ARTICLE";
        ArrayList<Article> articleList = new ArrayList<>();
        try {
            Connection con = Config.getSQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
            while(set.next()) {
                Article article = new Article();
                article.setId(set.getInt("ID"));
                article.setName(set.getString("NAME"));
                article.setPrice(set.getInt("PRICE"));
                article.setAmount(set.getInt("AMOUNT"));
                articleList.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articleList;

    }

    public void reduceAmount(int amount, int id) throws SQLException {
        Connection con = Config.getSQLConnection();

        String sql = "UPDATE ARTICLE SET AMOUNT="+amount+ "WHERE ID="+id;
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.execute();

    }

    public ArrayList<Article> getArticles(Article a) throws SQLException {

        String search = a.getName();
        Connection con = Config.getSQLConnection();

        //search.toUpperCase();
        String sql = "SELECT * FROM ARTICLE WHERE NAME LIKE '"+search+"%'";
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Article> articleList = new ArrayList<Article>();

        while(resultSet.next()) {
            Article article = new Article();
            article.setId(resultSet.getInt("ID"));
            article.setName(resultSet.getString("NAME"));
            article.setPrice(resultSet.getInt("PRICE"));
            article.setAmount(resultSet.getInt("AMOUNT"));
            articleList.add(article);
            //articleList.listIterator().next();

        }
        return articleList;
    }
}
