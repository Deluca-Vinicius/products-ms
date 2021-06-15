package com.testeVinicius.productms.controller;

import com.testeVinicius.productms.entities.Product;
import com.testeVinicius.productms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public List<Product> ProductsList() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @GetMapping("/{id}")
    public Optional<Product> SearchProductById(@PathVariable String id) {
        Optional<Product> product = productRepository.findById(id);
        return product;
    }
}

/*
POST 	/products 	Criação de um produto
PUT 	/products/ 	Atualização de um produto
GET 	/products/ 	Busca de um produto por ID
GET 	/products 	Lista de produtos
GET 	/products/search 	Lista de produtos filtrados
DELETE 	/products/ 	Deleção de um produto
*/