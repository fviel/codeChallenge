/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.viel.codechallenge;

import com.viel.codechallenge.entities.Assets;
import com.viel.codechallenge.services.CryptoService;
import com.viel.codechallenge.services.ResourcesService;

/**
 *
 * @author fernando
 */
public class CodeChallenge {

    public static void main(String[] args) {
        CryptoService cs = new CryptoService();
        ResourcesService rs = new ResourcesService();

        Assets assets = cs.getAllAssetsAsObject();
        System.out.println(assets);
//        rs.printWallet();
//        
//        Wallet wallet = rs.readWallet();
//        System.out.println(wallet);

//        String resp = cs.getAllAssets();
//        System.out.println(resp);

//        String resp2 = cs.getAssetHistoryAsString("bitcoin", "d1", "1617753600000", "1617753601000");
//        System.out.println(resp2);
//        Gson gson = new Gson();
//        HistoryQuotationResponse asset1 = gson.fromJson(resp2, HistoryQuotationResponse.class);
//        System.out.println("Asset1 como objeto: " + asset1);
        
        
//        String resp3 = cs.getAssetHistory("ethereum", "d1", "1617753600000", "1617753601000");
//        System.out.println(resp3);
        
    }
}
