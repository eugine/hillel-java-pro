package ua.ithillel.spring.core;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository  {

    List<Product> findAll();
    Optional<Product> findById(Long id);

}
