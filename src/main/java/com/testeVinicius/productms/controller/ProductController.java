package com.testeVinicius.productms.controller;

import com.testeVinicius.productms.entities.Product;
import com.testeVinicius.productms.form.ProductForm;
import com.testeVinicius.productms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> productsList() {
        List<Product> products = productService.productsList();
        return products;
    }

    @GetMapping("/{id}")
    public Optional<Product> searchProductById(@PathVariable String id) {
        Optional<Product> product = productService.searchProductById(id);
        return product;
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam(required = false) Integer min_price,
                                            @RequestParam(required = false) Integer max_price,
                                            @RequestParam(required = false) String q) {
        List<Product> products = productService.searchProducts(min_price, max_price, q);
        return products;
    }

    @PostMapping
    public ResponseEntity<Product> insertProduct(@RequestBody ProductForm form) {
        Product product = productService.insertProduct(form);
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody ProductForm form) {
        Product product = productService.updateProduct(id, form);
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Product> deleteProduct(@PathVariable String id) {
        ResponseEntity<Product> response = productService.deleteProduct(id);
        return response;
    }

}