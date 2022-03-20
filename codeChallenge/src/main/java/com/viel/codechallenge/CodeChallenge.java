/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.viel.codechallenge;

import com.viel.codechallenge.services.CryptoService;

/**
 *
 * @author fernando
 */
public class CodeChallenge {

    public static void main(String[] args) {
      CryptoService cs = new CryptoService();
      
      String resp = cs.getAllAssets();
        System.out.println(resp);
    }
}
