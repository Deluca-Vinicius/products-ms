package com.testeVinicius.productms.repository;

import com.testeVinicius.productms.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findById(String id);

    Product getById(String id);

    @Modifying
    @Query("Delete from Product P where P.id = :id")
    void deleteById(@Param("id") String id);

    @Query("SELECT P FROM Product P " +
            "where ((P.name like CONCAT('%',lower(?3),'%') or P.description like CONCAT('%',lower(?3),'%')) or ?3 is null) " +
            "and (?2 is null or P.price <= ?2) " +
            "and (?1 is null or P.price >= ?1)")
    List<Product> SearchProduct(@Param("?1") Integer min_price,
                                @Param("?2") Integer max_price,
                                @Param("?3") String q);
}