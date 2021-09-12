package dio.santander.shoppingcart.model;

import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.redis.core.RedisHash;

//@RedisHash("item")
@Document(indexName = "item", type = "catalog")
public class Item {

    private Integer productId;
    private Integer amount;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
