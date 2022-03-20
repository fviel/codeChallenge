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
public class Wallet {

    private List<WalletItem> itens;

    private void initiateItens(){
        if(Objects.isNull(itens)){
            itens = new ArrayList<>();
        }
    }
    
    public boolean addWalletItem(WalletItem wi){
        if(Objects.isNull(wi)){
            return false;
        }        
        initiateItens();
        itens.add(wi);
        return true;
    }    

    @Override
    public String toString() {
        String response = "Wallet{" + "\nitens=";
        for (WalletItem wi : itens) {
            response = response + wi.toString() + "\n";
        }
        response = response + "\n}";
        return response;
    }
}
