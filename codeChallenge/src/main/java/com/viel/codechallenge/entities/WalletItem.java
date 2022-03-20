/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viel.codechallenge.entities;

/**
 *
 * @author fernando
 */
public class WalletItem {
    private String symbol;
    private String quantity;
    private String price;

    public WalletItem() {
    }

    public WalletItem(String symbol, String quantity, String price) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
    }
    
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "WalletItem{" + "symbol=" + symbol + ", quantity=" + quantity + ", price=" + price + '}';
    }
}
