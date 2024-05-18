package com.richardvynz.StockManager_Application.controller;

import com.richardvynz.StockManager_Application.dto.StockRequest;
import com.richardvynz.StockManager_Application.entity.Stock;
import com.richardvynz.StockManager_Application.service.StockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/api/stocks")
@Tag(name = "STOCK MANAGEMENT API")
public class StockController {

    private final StockService stockService;

    @Operation(summary = "List of all the stocks present in the store")
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 for OK"
    )
    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> stockList = stockService.getAllStocks();
        return new ResponseEntity<>(stockList,HttpStatus.OK);
    }

    @Operation(summary = "searching for a particular stock with its stock identifier")
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 for OK"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        Stock stockById = stockService.getStockById(id);
        return new ResponseEntity<>(stockById,HttpStatus.OK);
    }

    @Operation(summary = "Updating the price of a stock")
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 for OK"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStockPrice(@PathVariable Long id, @RequestBody BigDecimal newPrice) {
        Stock updateStockPrice = stockService.updateStockPrice(id, newPrice);
        return new ResponseEntity<>(updateStockPrice,HttpStatus.OK);
    }

    @Operation(summary = "Creating a new User stock and assigning it a price")
    @ApiResponse(
            responseCode = "201",
            description = "Http status 201 for CREATED"
    )
    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody StockRequest request) {
        Stock createdStock = stockService.createStock(request);
        return new ResponseEntity<>(createdStock,HttpStatus.CREATED);
    }


}

