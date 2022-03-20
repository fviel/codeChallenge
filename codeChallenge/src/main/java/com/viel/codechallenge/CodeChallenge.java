/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.viel.codechallenge;

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

        rs.printWallet();

//        String resp = cs.getAllAssets();
//        System.out.println(resp);
    }
}
