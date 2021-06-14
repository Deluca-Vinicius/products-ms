package com.testeVinicius.productms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @GetMapping
    public String healthCheck(){
        return "up";
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