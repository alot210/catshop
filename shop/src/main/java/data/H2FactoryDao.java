package data;

public class H2FactoryDao {

    public static H2ArticleDao getDaoArticle(){
        return new H2ArticleDao();
    }

    public static H2UserDao getDaoUser(){
        return new H2UserDao();
    }

    public static H2UserDaoMockUp getMockUp(){ return new H2UserDaoMockUp();}
}
