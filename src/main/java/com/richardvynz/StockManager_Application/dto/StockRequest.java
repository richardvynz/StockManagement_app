package com.richardvynz.StockManager_Application.dto;

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
    @NotBlank
    private BigDecimal currentPrice;
}
