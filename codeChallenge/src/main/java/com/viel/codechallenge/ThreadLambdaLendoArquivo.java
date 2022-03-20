/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viel.codechallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ThreadLambdaLendoArquivo {
    private static List<String> dadosArquivos;    
    
    ThreadLambdaLendoArquivo(){
        dadosArquivos = new ArrayList<>();
    }
    
    private static void print(List<String> dados){
        System.out.println("RESULTADO LEITURA");
        for(String s : dados){
            System.out.println(s);
        }
    }    

//    public static void main(String[] args) {
//        dadosArquivos = new ArrayList<>();
//        
//        Runnable tfv1 = () -> {                
//                TesteArquivos ta = new TesteArquivos("/home/fernando/testeArquivo1.txt", "tfv1");
//                //ta.readAndPrint();
//                List<String> contentReaded = ta.readBufferedFileContent();                
//                dadosArquivos.addAll(contentReaded);
//        };        
//        
//        Runnable tfv2 = () -> {                
//                TesteArquivos ta = new TesteArquivos("/home/fernando/testeArquivo2.txt", "tfv2");
//                //ta.readAndPrint(); 
//                List<String>  contentReaded = ta.readBufferedFileContent();                
//                dadosArquivos.addAll(contentReaded);
//        };        
//        
//        Runnable tfv3 = () -> {                
//                TesteArquivos ta = new TesteArquivos("/home/fernando/testeArquivo3.txt" ,"tfv3");
//                //ta.readAndPrint();           
//                List<String>  contentReaded = ta.readBufferedFileContent();                
//                dadosArquivos.addAll(contentReaded);
//        };        
//        
//        Thread tfv4 = new Thread(()-> System.out.println("foo"));
//        
//        tfv1.run();
//        tfv2.run();
//        tfv3.run();
//        tfv4.run();  
//        
//        print(dadosArquivos);
//    }        
}


class TesteArquivos {
    
    private String path;
    private String readerName;

    public TesteArquivos(String path, String name) {
        this.path = path;
        this.readerName = name;
    }  
    
    public List<String> readBufferedFileContent(){
        File source = new File(path);
        List<String> dados = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader( new FileReader(source));
            String s;
            while(( s = reader.readLine()) != null){
                dados.add(readerName + " - " + s);
            }
            
            return dados;
        }catch(IOException ioe){
            ioe.printStackTrace();
            return null;
        }
    }
    
    private void print(List<String> dados){
        for(String s : dados){
            System.out.println(s);
        }
    }
    
    public void readAndPrint() {
        List<String> dados = readBufferedFileContent();
        print(dados);        
    } 
    
}

