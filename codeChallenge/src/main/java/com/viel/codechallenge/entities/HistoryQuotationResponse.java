/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viel.codechallenge.entities;

import java.util.List;

/**
 *
 * @author fernando
 */
public class HistoryQuotationResponse {
    private List<Quotation> data;
    private Long timestamp;

    public List<Quotation> getData() {
        return data;
    }

    public void setData(List<Quotation> data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        
        String resp = "HistoryQuotationResponse{ data= \n";
        for(Quotation q : data){
            resp = resp + q.toString() + "\n";
        }
        resp = resp + "\n, timestamp=" + timestamp + '}';
        return resp;
    }
    
    
}
