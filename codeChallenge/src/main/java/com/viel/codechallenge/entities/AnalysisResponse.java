/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viel.codechallenge.entities;

import java.math.BigDecimal;

/**
 *
 * @author fernando
 */
public class AnalysisResponse {
    private BigDecimal total;
    private String bestAsset;
    private BigDecimal bestPerformance;
    private String worstAsset;
    private BigDecimal worstPerformance;

    public AnalysisResponse() {
        this.total = BigDecimal.ZERO;
        this.bestAsset = "none";
        this.bestPerformance = BigDecimal.ZERO;
        this.worstAsset = "none";
        this.worstPerformance = BigDecimal.ZERO;
    }

    
    
    
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getBestAsset() {
        return bestAsset;
    }

    public void setBestAsset(String bestAsset) {
        this.bestAsset = bestAsset;
    }

    public BigDecimal getBestPerformance() {
        return bestPerformance;
    }

    public void setBestPerformance(BigDecimal bestPerformance) {
        this.bestPerformance = bestPerformance;
    }

    public String getWorstAsset() {
        return worstAsset;
    }

    public void setWorstAsset(String worstAsset) {
        this.worstAsset = worstAsset;
    }

    public BigDecimal getWorstPerformance() {
        return worstPerformance;
    }

    public void setWorstPerformance(BigDecimal worstPerformance) {
        this.worstPerformance = worstPerformance;
    }

    @Override
    public String toString() {
        return "AnalysisResponse{" + "total=" + total + ", best_asset=" + bestAsset + ", best_performance=" + bestPerformance + ", worst_asset=" + worstAsset + ", worst_performance=" + worstPerformance + '}';
    }
    
    
}
