package transferModels;

import java.util.List;

public class ShoppingCart {

    //TODO
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
}
