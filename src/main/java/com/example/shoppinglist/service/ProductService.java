package com.example.shoppinglist.service;

import com.example.shoppinglist.models.Product;
import com.example.shoppinglist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void save(String title, String category) {
        Product product = new Product(title, category);
        productRepository.save(product);
    }

    public void update(Long id, String title, String category, boolean isBought) {
        Product product = new Product(id, title, category);
        product.setBought(isBought);
        productRepository.save(product);
    }

    public void delete(Long id) {
        var product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Iterable<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
