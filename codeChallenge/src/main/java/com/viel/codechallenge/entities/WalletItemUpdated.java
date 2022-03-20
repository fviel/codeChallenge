/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viel.codechallenge.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 *
 * @author fernando
 */
public class WalletItemUpdated {

    private String symbol;
    private BigDecimal quantity;
    private BigDecimal originalPrice;
    private BigDecimal updatedPrice;
    private BigDecimal performance;
    private BigDecimal itemValue;

    public WalletItemUpdated(WalletItem wi) {
        this.symbol = wi.getSymbol();
        this.originalPrice = new BigDecimal(wi.getPrice().replaceAll(",", ""));
        this.quantity = new BigDecimal(wi.getQuantity().replaceAll(",", ""));
        this.updatedPrice = BigDecimal.ZERO;
        this.performance = BigDecimal.ZERO;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getUpdatedPrice() {
        return updatedPrice;
    }

    public void setUpdatedPrice(BigDecimal updatedPrice) {
        this.updatedPrice = updatedPrice;
        calcPerformance();
        calcItemValue();
    }

    public BigDecimal getPerformance() {
        return performance;
    }

    private void calcPerformance() {
        if (Objects.nonNull(originalPrice)
                && !originalPrice.equals(BigDecimal.ZERO)) {
            this.performance = updatedPrice.divide(originalPrice,RoundingMode.HALF_UP);
        } else {
            this.performance = BigDecimal.ZERO;
        }
    }

    public BigDecimal getItemValue() {
        return itemValue;
    }

    public void calcItemValue() {
        this.itemValue = this.quantity.multiply(this.updatedPrice);
    }
    
    

    @Override
    public String toString() {
        return "WalletItemUpdated{" + "symbol=" + symbol + ", quantity=" + quantity + ", originalPrice=" + originalPrice + ", updatedPrice=" + updatedPrice + ", performance=" + performance + '}';
    } 
}