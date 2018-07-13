package transferModels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable {

    private List<Article> articleList;
    private int sum;

    public ShoppingCart(){}

    public  ShoppingCart(List<Article> articleList){
        this.articleList = articleList;
    }


    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public List<Article> getArticleList() {
        return this.articleList;
    }

    public void setArticleList(List<Article> list) {
        this.articleList = list;
    }

    public void resetCart(){
        this.articleList = new ArrayList<Article>(); {
        }
    }
}

