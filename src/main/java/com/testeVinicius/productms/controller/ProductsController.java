package com.testeVinicius.productms.controller;

import com.testeVinicius.productms.entities.Product;
import com.testeVinicius.productms.form.ProductForm;
import com.testeVinicius.productms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public List<Product> productsList() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @GetMapping("/{id}")
    public Optional<Product> searchProductById(@PathVariable String id) {
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    @PostMapping
    public ResponseEntity<Product> insertProduct(@RequestBody ProductForm form) {
        Product product = form.insertConverter();
        productRepository.save(product);
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody ProductForm form) {
        Product product = form.updateConverter(id, productRepository, form);
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Product> deleteProduct(@PathVariable String id) {

        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.delete(id);
            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.notFound().build();
    }

}

/*
GET 	/products/search 	Lista de produtos filtrados
*/