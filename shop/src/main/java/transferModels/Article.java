package transferModels;

import java.io.Serializable;
import java.util.Map;
public class Article implements Serializable {

    private String id;
    private String name;
    private int price;
    private int amount;
    private String image;

    public Article(){

    }

    public Article(String id, String name, int price, int amount, String image){
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.image = image;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getImage() { return image; }

    public void setImage(String image) { this.image  = image; }
}
