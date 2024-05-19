package com.richardvynz.StockManager_Application.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StockRequest {
    
    @NotBlank
    private String name;
    @DecimalMin(value = "0.0", inclusive = false, message = "Current price must be greater than zero")
    private BigDecimal currentPrice;
}
