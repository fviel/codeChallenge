/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viel.codechallenge.services;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
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

    public String getAllAssets() {
        String response = service.path("/v2").path("/assets").accept(MediaType.APPLICATION_JSON).get(String.class);
        return response;
    }

    public String getAssetHistory(String id, String interval, String start, String end) {
//        MultivaluedMap <String, String> params = new MultivaluedMapImpl();
//        params.add("start", start);
//        params.add("end", end);

        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        params.add("interval", interval);
        params.add("start", start);
        params.add("end", end);

        //String response = service.path("/v2").path("/assets").path(id+"/history").path("/d1").queryParams(params).accept(MediaType.APPLICATION_JSON).get(String.class);
        String response = service.path("/v2").path("/assets").path(id + "/history").queryParams(params).accept(MediaType.APPLICATION_JSON).get(String.class);
        return response;
    }

}
