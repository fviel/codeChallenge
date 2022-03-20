/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viel.codechallenge.business;

import com.viel.codechallenge.entities.AnalysisResponse;
import com.viel.codechallenge.entities.Assets;
import com.viel.codechallenge.entities.HistoryQuotationResponse;
import com.viel.codechallenge.entities.Wallet;
import com.viel.codechallenge.entities.WalletItem;
import com.viel.codechallenge.entities.WalletItemUpdated;
import com.viel.codechallenge.services.CryptoService;
import com.viel.codechallenge.services.ResourcesService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author fernando
 */
public class AssetBusiness {

    public void getData() {
        CryptoService cs = new CryptoService();
        ResourcesService rs = new ResourcesService();

        //carrega a tabela de assets para pesquisa de símbolos
        Assets assets = cs.getAllAssetsAsObject();

        Wallet wallet = rs.readWallet();

        //cria um pool de threads do tamanho da carteira
        ExecutorService exec = Executors.newFixedThreadPool(wallet.getSize());

        List<Callable<WalletItemUpdated>> tasks = new ArrayList<>();

        for (WalletItem wi : wallet.getItens()) {
            Callable<WalletItemUpdated> task = () -> {
                String id = assets.getIdBySymbol(wi.getSymbol());
                HistoryQuotationResponse hqr = cs.getAssetHistoryAsObject(id, "d1", "1617753600000", "1617753601000");
                WalletItemUpdated wiu = new WalletItemUpdated(wi);
                wiu.setUpdatedPrice(new BigDecimal(hqr.getData().get(0).getPriceUsd().replaceAll(",", "")));
                return wiu;
            };
            tasks.add(task);
        }

        List<WalletItemUpdated> updatedWalletItens = new ArrayList<>();
        try {
            List<Future<WalletItemUpdated>> retornosFuturos = exec.invokeAll(tasks);
            for (Future<WalletItemUpdated> f : retornosFuturos) {
                updatedWalletItens.add(getFutureResponseAsWalletItemUpdated(f));
                System.out.println(getFutureResponseAsWalletItemUpdated(f));
            } 
             
            AnalysisResponse response  = analiseWallet(updatedWalletItens);
            System.out.println(response);
            
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        exec.shutdown();
        List<Runnable> tasksNaoExecutadas;
        try {
            if (!exec.awaitTermination(500, TimeUnit.MILLISECONDS)) {
                tasksNaoExecutadas = exec.shutdownNow();
            }
        } catch (InterruptedException ie) {
            tasksNaoExecutadas = exec.shutdownNow();
        }       
    }

    private AnalysisResponse analiseWallet(List<WalletItemUpdated> wiuList) {
        AnalysisResponse resp = new AnalysisResponse();
        
        BigDecimal total = BigDecimal.ZERO;
        WalletItemUpdated best = wiuList.get(0);
        WalletItemUpdated worst = wiuList.get(0);

        for(WalletItemUpdated wiu : wiuList){
            //defines total
            total = total.add(wiu.getItemValue());    
            
            //identifies the best
            //int comparisonB = best.getPerformance().compareTo(wiu.getPerformance());
            if(best.getPerformance().compareTo(wiu.getPerformance()) == -1){
                best = wiu;
            }
            
            //identifies the worst
            //int comparisonW = worst.getPerformance().compareTo(wiu.getPerformance());
            if(worst.getPerformance().compareTo(wiu.getPerformance()) == -1){
                worst = wiu;
            }
        }
        
        resp.setBestAsset(best.getSymbol());
        resp.setBestPerformance(best.getPerformance());
        resp.setTotal(total);
        resp.setWorstAsset(worst.getSymbol());
        resp.setWorstPerformance(worst.getPerformance());               
        return resp;
    }
 

    private void printFutureResponse(Future<WalletItemUpdated> futureResponse) {
        WalletItemUpdated resp;
        try {
            resp = futureResponse.get();
            System.out.println(resp);
        } catch (Exception ie) {
            ie.printStackTrace();
        }
    }

    private WalletItemUpdated getFutureResponseAsWalletItemUpdated(Future<WalletItemUpdated> futureResponse) {
        WalletItemUpdated resp;
        try {
            return futureResponse.get();
        } catch (Exception ie) {
            ie.printStackTrace();
            return null;
        }
    }
}
