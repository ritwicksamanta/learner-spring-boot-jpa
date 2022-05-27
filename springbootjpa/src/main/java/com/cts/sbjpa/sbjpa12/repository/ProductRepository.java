package com.cts.sbjpa.sbjpa12.repository;

import com.cts.sbjpa.sbjpa12.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByContainsName(String name);

    List<Product> findByName(String name);

    List<Product> findByQuantityBetween(int start, int end);
}
