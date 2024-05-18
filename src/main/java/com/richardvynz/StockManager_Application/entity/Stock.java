package com.richardvynz.StockManager_Application.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Stocks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "STOCK_NAME")
    private String name;
    @Column(name = "STOCK_PRICE",nullable = false)
    private BigDecimal currentPrice;
    @CreationTimestamp
    @Column(name = "DATE_CREATED",nullable = false)
    private LocalDateTime createDate;
    @UpdateTimestamp
    @Column(name = "DATE_UPDATED",nullable = false)
    private LocalDateTime lastUpdate;
}
