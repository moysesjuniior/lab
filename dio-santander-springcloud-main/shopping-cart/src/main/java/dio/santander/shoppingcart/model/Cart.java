package dio.santander.shoppingcart.model;

import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.redis.core.RedisHash;

import java.util.ArrayList;
import java.util.List;

//@RedisHash("cart")
@Document(indexName = "cart", type = "catalog")
public class Cart {

    private Integer id;
    private List<Item> items;

    public Cart(){}

    public Cart(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Item> getItems() {
        if(this.items == null){
            this.items = new ArrayList<>();
        }

        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
