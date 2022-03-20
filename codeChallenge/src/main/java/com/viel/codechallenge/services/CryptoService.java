/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viel.codechallenge.services;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.viel.codechallenge.entities.Asset;
import com.viel.codechallenge.entities.Assets;
import com.viel.codechallenge.entities.HistoryQuotationResponse;
import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author fernando
 */
public class CryptoService {

    private ClientConfig config;
    private Client client;
    private WebResource service;

    public CryptoService() {
        config = new DefaultClientConfig();
        client = Client.create(config);
        service = client.resource(UriBuilder.fromUri("https://api.coincap.io").build());
    }

    public String getAllAssetsAsString() {
        String response = service.path("/v2").path("/assets").accept(MediaType.APPLICATION_JSON).get(String.class);
        return response;
    }
    
    public Assets getAllAssetsAsObject(){
        String res = getAllAssetsAsString();
        Gson gson = new Gson();
        Assets response = gson.fromJson(res, Assets.class);
        return response;       
    }

    public String getAssetHistoryAsString(String id, String interval, String start, String end) {
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        params.add("interval", interval);
        params.add("start", start);
        params.add("end", end);
        String response = service.path("/v2").path("/assets").path(id + "/history").queryParams(params).accept(MediaType.APPLICATION_JSON).get(String.class);
        return response;
    }
    
    public HistoryQuotationResponse getAssetHistoryAsObject(String id, String interval, String start, String end) {
        Gson gson = new Gson();
        HistoryQuotationResponse response = gson.fromJson(getAssetHistoryAsString( id,  interval,  start,  end), HistoryQuotationResponse.class);
        return response;
    }
    
    

}
