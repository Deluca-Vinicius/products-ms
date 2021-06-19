package com.testeVinicius.productms.controller;

import com.testeVinicius.productms.entities.Product;
import com.testeVinicius.productms.form.ProductForm;
import com.testeVinicius.productms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
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
    public ResponseEntity<Product> searchProductById(@PathVariable String id) {
        Optional<Product> product = productService.searchProductById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok().body(product.get());
        } else
            return ResponseEntity.notFound().build();
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
        return productService.insertProduct(form);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody ProductForm form) {
        return productService.updateProduct(id, form);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Product> deleteProduct(@PathVariable String id) {
        ResponseEntity<Product> response = productService.deleteProduct(id);
        return response;
    }

}