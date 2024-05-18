package com.richardvynz.StockManager_Application.dto.model;

import com.richardvynz.StockManager_Application.entity.Stock;
import com.richardvynz.StockManager_Application.repository.StockRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class InMemoryData {

    @Autowired
    private StockRepository stockRepository;

    @PostConstruct
    public void seedData() {
        Stock firstStock = new Stock();
        firstStock.setName("Stock1");
        firstStock.setCurrentPrice(new BigDecimal("100.00"));
        firstStock.setCreateDate(LocalDateTime.now());
        firstStock.setLastUpdate(LocalDateTime.now());

        Stock secondStock = new Stock();
        secondStock.setName("Stock2");
        secondStock.setCurrentPrice(new BigDecimal("150.00"));
        secondStock.setCreateDate(LocalDateTime.now());
        secondStock.setLastUpdate(LocalDateTime.now());

        Stock thirdStock = new Stock();
        thirdStock.setName("Stock3");
        thirdStock.setCurrentPrice(new BigDecimal("950.00"));
        thirdStock.setCreateDate(LocalDateTime.now());
        thirdStock.setLastUpdate(LocalDateTime.now());

        stockRepository.save(firstStock);
        stockRepository.save(secondStock);
        stockRepository.save(thirdStock);
    }

}
