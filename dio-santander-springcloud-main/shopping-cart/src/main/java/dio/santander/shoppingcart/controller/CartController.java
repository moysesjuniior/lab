package dio.santander.shoppingcart.controller;

import dio.santander.shoppingcart.model.Cart;
import dio.santander.shoppingcart.model.Item;
import dio.santander.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartRepository cartRepository;

    @Autowired
    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @PostMapping("/{id}")
    public Cart addItem(@PathVariable("id") Integer id, @RequestBody Item item){
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;

        if(savedCart.equals(Optional.empty())){
            cart = new Cart();
            cart.setId(id);
        } else {
            cart = savedCart.get();
        }

        cart.getItems().add(item);

        return cartRepository.save(cart);
    }

    @GetMapping
    public Iterable<Cart> findAll(){
        return cartRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cart> findById(@PathVariable("id") Integer id){
        return cartRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void clear(@PathVariable("id") Integer id){
        this.cartRepository.deleteById(id);
    }
}
