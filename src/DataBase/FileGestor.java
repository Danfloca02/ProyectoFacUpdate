/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ingenieriadesoftware.facupdate.DataBase;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author USER
 */
public class FileGestor {
    public File openFile(String path){
        //opens the file, and create it if doesn't exist 
        File file = new File(path);
        try{
            if(file.createNewFile()){
                System.out.print(file.getName());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return file;
    }
    public BufferedReader getBufferedReader(String path, boolean mode) throws IOException{
        //return a bufferedReader with the path specified
        File rd = openFile(path);
        BufferedReader rt = new BufferedReader(new FileReader(rd));
        return rt;
    }
    public BufferedWriter getBufferedWriter(String path, boolean mode) throws IOException{
        //return a bufferedReader with the path specified
        File rd = openFile(path);
        BufferedWriter rt = new BufferedWriter(new FileWriter(rd));
        return rt;
    }
    public Scanner getScanner(String path) throws IOException{
        File rd = openFile(path);
        return (new Scanner(rd));
    }
    
}
