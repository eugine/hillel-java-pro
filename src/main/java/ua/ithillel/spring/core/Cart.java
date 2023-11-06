package ua.ithillel.spring.core;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private final List<Product> products;
    private final ProductRepository productRepository;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.products = new ArrayList<>();
    }

    public void add(Long id) {
        productRepository.findById(id)
                .ifPresentOrElse(
                        products::add,
                        () -> {
                            throw new RuntimeException("Product not found");
                        });
    }

    public void delete(Long id) {
        products.stream()
                .filter(product -> product.id().equals(id))
                .findFirst()
                .ifPresent(products::remove);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }
}
