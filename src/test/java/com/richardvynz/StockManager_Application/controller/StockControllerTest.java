package com.richardvynz.StockManager_Application.controller;

import com.richardvynz.StockManager_Application.dto.StockRequest;
import com.richardvynz.StockManager_Application.entity.Stock;
import com.richardvynz.StockManager_Application.service.StockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class StockControllerTest {

    @Mock
    private StockService stockService;

    @InjectMocks
    private StockController stockController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("get all the stocks present in store")
            void getAllStocksPresent(){
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock(1L,"firstStock", BigDecimal.valueOf(100.00),null,null));
        stocks.add(new Stock(1L,"secondStock", BigDecimal.valueOf(200.00),null,null));

        when(stockService.getAllStocks()).thenReturn(stocks);

        ResponseEntity<List<Stock>> stockResponse = stockController.getAllStocks();

        assertEquals(HttpStatus.OK, stockResponse.getStatusCode());
        assertEquals(2,stockResponse.getBody().size());
    }


    @Test
    @DisplayName("given valid input parameters, create a new stock")
    void createStock(){
        StockRequest request = new StockRequest("firstProduct",BigDecimal.valueOf(100.00));
      Stock stock =  new Stock(1L,"firstStock", BigDecimal.valueOf(100.00), LocalDateTime.now(),LocalDateTime.now());
        when(stockService.createStock(request)).thenReturn(stock);

        ResponseEntity <Stock> response = stockController.createStock(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(stock, response.getBody());
    }


    @Test
    @DisplayName("Given a valid id return the product with the specified identifier")
    void getStockById(){
        Stock stock = new Stock(1L,"firstStock",BigDecimal.valueOf(240.00),null,null);

        when(stockService.getStockById(1L)).thenReturn(stock);

        ResponseEntity<Stock> response = stockController.getStockById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stock,response.getBody());
    }

    @Test
    @DisplayName("Given a valid id and price, update the price of a stock")
    void updateProductPrice(){
        Stock stock = new Stock(1L,"firstProduct",BigDecimal.valueOf(200.00),null, null);

        when(stockService.updateStockPrice(1L,BigDecimal.valueOf(2300.00))).thenReturn(stock);

        ResponseEntity<Stock> response = stockController.updateStockPrice(1L,BigDecimal.valueOf(2300.00));

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(stock, response.getBody());
    }

}