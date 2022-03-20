/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viel.codechallenge.services;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author fernando
 */
public class CryptoService {

    private ClientConfig config;
    private Client client;

    public CryptoService() {
        config = new DefaultClientConfig();
        client = Client.create(config);
    }

    public String getAllAssets() {
        WebResource service = client.resource(UriBuilder.fromUri("https://api.coincap.io").build());
        String response = service.path("/v2").path("assets").accept(MediaType.APPLICATION_JSON).get(String.class);
        return response;
    }

}
