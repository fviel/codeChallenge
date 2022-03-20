/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viel.codechallenge.entities;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author fernando
 */
public class Asset {

    
    private String id;
    private int rank;
    private String symbol;
    private String name;
    private BigDecimal supply;
    private BigDecimal maxSupply;
    private BigDecimal marketCapUsd;
    private BigDecimal volumeUsd24Hr;
    private BigDecimal priceUsd;
    private BigDecimal changePercent24Hr;
    private BigDecimal vwap24Hr;
    private String explorer;

    public Asset() {
    }

    public String getExplorer() {
        return explorer;
    }

    public void setExplorer(String explorer) {
        this.explorer = explorer;
    }

         

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSupply() {
        return supply;
    }

    public void setSupply(BigDecimal supply) {
        this.supply = supply;
    }

    public BigDecimal getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(BigDecimal maxSupply) {
        this.maxSupply = maxSupply;
    }

    public BigDecimal getMarketCapUsd() {
        return marketCapUsd;
    }

    public void setMarketCapUsd(BigDecimal marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public BigDecimal getVolumeUsd24Hr() {
        return volumeUsd24Hr;
    }

    public void setVolumeUsd24Hr(BigDecimal volumeUsd24Hr) {
        this.volumeUsd24Hr = volumeUsd24Hr;
    }

    public BigDecimal getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(BigDecimal priceUsd) {
        this.priceUsd = priceUsd;
    }

    public BigDecimal getChangePercent24Hr() {
        return changePercent24Hr;
    }

    public void setChangePercent24Hr(BigDecimal changePercent24Hr) {
        this.changePercent24Hr = changePercent24Hr;
    }

    public BigDecimal getVwap24Hr() {
        return vwap24Hr;
    }

    public void setVwap24Hr(BigDecimal vwap24Hr) {
        this.vwap24Hr = vwap24Hr;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Asset other = (Asset) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Asset{" + "id=" + id + ", rank=" + rank + ", symbol=" + symbol + ", name=" + name + ", supply=" + supply + ", maxSupply=" + maxSupply + ", marketCapUsd=" + marketCapUsd + ", volumeUsd24Hr=" + volumeUsd24Hr + ", priceUsd=" + priceUsd + ", changePercent24Hr=" + changePercent24Hr + ", vwap24Hr=" + vwap24Hr + ", explorer=" + explorer + '}';
    }       
}
