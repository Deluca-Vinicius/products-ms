package com.testeVinicius.productms.service;

import com.testeVinicius.productms.entities.Product;
import com.testeVinicius.productms.form.ProductForm;
import com.testeVinicius.productms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
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

    public ResponseEntity<Product> insertProduct(ProductForm form) {
        Assert.notNull(form.getDescription(), "Add a description");
        Assert.notNull(form.getName(), "Please inform the name");
        Assert.notNull(form.getPrice(), "Please inform price");
        Assert.isNull(form.getId(), "The ID can't be informed");
        Product product = form.insertConverter();
        productRepository.save(product);
        URI location = getUri(product.getId());
        return ResponseEntity.created(location).body(product);
    }

    public ResponseEntity<Product> updateProduct(String id, ProductForm form) {

        Optional<Product> productSearch = productRepository.findById(id);
        if (productSearch.isPresent()) {
            Product product = form.updateConverter(id, productRepository, form);
            URI location = getUri(product.getId());
            return ResponseEntity.created(location).body(product);
        } else
            return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Product> deleteProduct(String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.notFound().build();
    }

    private URI getUri(String id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

}
