/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viel.codechallenge.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author fernando
 */
public class ResourcesService {
    
    public void printWallet(){
        InputStream is = getFileFromResourcesAsInputStream("wallet.csv");
        List<String> lines = readBufferedFileContent(is);
        print(lines);
    }
    
    public InputStream getFileFromResourcesAsInputStream(String filename){
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream is = classLoader.getResourceAsStream(filename);
        if(Objects.isNull(is)){
            throw new IllegalArgumentException("File " + filename + " not found.");
        }else{
            return is;
        }
    }
    
    public File getFileFromResource(String filename) throws URISyntaxException{
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(filename);
        if(Objects.isNull(resource)){
            throw new IllegalArgumentException("File " + filename + " not found.");
        }else{
            return new File(resource.toURI());
        }
    }
    
    public List<String> readBufferedFileContent(InputStream is){        
        List<String> data = new ArrayList<>();
        try{
            InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader); 
            String line;
            while(( line = reader.readLine()) != null){
                data.add(line);
            }            
            return data;
        }catch(IOException ioe){
            ioe.printStackTrace();
            return null;
        }
    }
    
    public void print(List<String> datas){
        for(String s : datas){
            System.out.println(s);
        }
    }    
}
