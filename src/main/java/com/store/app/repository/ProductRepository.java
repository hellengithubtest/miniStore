package com.store.app.repository;

import com.store.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //@Query("SELECT * FROM products WHERE products.name LIKE CONCAT('%',:name,'%')")
    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%',:q,'%')")
    List<Product> findUsersWithPartOfName(@Param("q") String q);
}
