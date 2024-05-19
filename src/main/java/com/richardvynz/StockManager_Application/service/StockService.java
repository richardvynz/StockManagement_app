package com.richardvynz.StockManager_Application.service;

import com.richardvynz.StockManager_Application.dto.StockRequest;
import com.richardvynz.StockManager_Application.entity.Stock;

import java.math.BigDecimal;
import java.util.List;

public interface StockService {
    List<Stock> getAllStocks();

    Stock getStockById(Long id);

    Stock updateStockPrice(Long id, BigDecimal newPrice);

    Stock createStock(StockRequest stock);

}
