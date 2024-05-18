package com.richardvynz.StockManager_Application.service.impl;

import com.richardvynz.StockManager_Application.dto.StockRequest;
import com.richardvynz.StockManager_Application.entity.Stock;
import com.richardvynz.StockManager_Application.exception.StockAlreadyExistException;
import com.richardvynz.StockManager_Application.exception.StockUnAvailableException;
import com.richardvynz.StockManager_Application.repository.StockRepository;
import com.richardvynz.StockManager_Application.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;

    @Override
    public List<Stock> getAllStocks() {
        log.info("Fetching all stocks");
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(Long id) {
        log.info("Fetching stock with id {}", id);
       return stockRepository.findById(id).orElseThrow(
                ()-> new StockUnAvailableException("NOT FOUND","Stock not found with id " + id));
    }

    @Override
    public Stock updateStockPrice(Long id, BigDecimal newPrice) {

        log.info("Updating stock price for id {}: new price {}", id, newPrice);
        Stock stockToUpdate = stockRepository.findById(id).orElseThrow(
                ()-> new StockUnAvailableException("NOT FOUND","Stock not found with id " + id));

        stockToUpdate.setCurrentPrice(newPrice);
        stockToUpdate.setLastUpdate(LocalDateTime.now());

        Stock updatedStock = stockRepository.save(stockToUpdate);
        log.info("Updated stock price for id {}: {}", id, updatedStock);

        return updatedStock;
    }

    @Override
    public Stock createStock(StockRequest request) {
        boolean existingStock = stockRepository.existsByName(request.getName());
        if (existingStock) {
            throw new StockAlreadyExistException("ALREADY EXIST","Stock with name " + request.getName() + " already exists");
        }

        Stock stock = new Stock();
        stock.setName(request.getName());
        stock.setCurrentPrice(request.getCurrentPrice());
        stock.setCreateDate(LocalDateTime.now());
        stock.setLastUpdate(LocalDateTime.now());

        return stockRepository.save(stock);
    }


}
