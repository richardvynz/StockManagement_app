package com.richardvynz.StockManager_Application.repository;

import com.richardvynz.StockManager_Application.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {
    boolean existsByName(String name);
}
