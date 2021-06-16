package com.testeVinicius.productms.repository;

import com.testeVinicius.productms.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findById(String id);

    Product getById(String id);

    void delete(String id);
}
