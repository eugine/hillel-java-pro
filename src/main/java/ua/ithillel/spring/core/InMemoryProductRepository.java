package ua.ithillel.spring.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class InMemoryProductRepository implements ProductRepository {
    private final List<Product> db;

    public InMemoryProductRepository(Collection<Product> initialDb) {
        this.db = new ArrayList<>(initialDb);
    }

    @Override
    public List<Product> findAll() {
        return db.stream().toList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return db.stream()
                .filter(product -> product.id().equals(id))
                .findAny();
    }
}
