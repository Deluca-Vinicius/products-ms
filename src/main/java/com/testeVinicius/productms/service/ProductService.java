package com.testeVinicius.productms.service;

import com.testeVinicius.productms.entities.Product;
import com.testeVinicius.productms.form.ProductForm;
import com.testeVinicius.productms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> productsList() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Optional<Product> searchProductById(String id) {
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    public List<Product> searchProducts(Integer min_price, Integer max_price, String q) {
        List<Product> products = productRepository.SearchProduct(min_price, max_price, q);
        return products;
    }

    public Product insertProduct(ProductForm form) {
        Product product = form.insertConverter();
        productRepository.save(product);
        return product;
    }

    public Product updateProduct(String id, ProductForm form) {
        Product product = form.updateConverter(id, productRepository, form);
        return product;
    }

    public ResponseEntity<Product> deleteProduct(String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.notFound().build();
    }

}
