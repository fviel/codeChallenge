/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viel.codechallenge.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author fernando
 */
public class Assets {
    private List<Asset> data;
    
    private void initiateAssets(){
        if(Objects.isNull(data)){
            data = new ArrayList<>();
        }
    }
    
    public boolean addWalletItem(Asset asset){
        if(Objects.isNull(asset)){
            return false;
        }        
        initiateAssets();
        data.add(asset);
        return true;
    }    

    @Override
    public String toString() {
        String response = "Assets{" + "\nasset=";
        for (Asset asset : data) {
            response = response + asset.toString() + "\n";
        }
        response = response + "\n}";
        return response;
    }
    
    public String getIdBySymbol(String symbol){
        for(Asset a : data){
            if(a.getSymbol().equals(symbol)){
                return a.getId();
            }
        }
        return null;
    }
}
