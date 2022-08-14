package com.miu.ea.cs544.programmingtest2.service;

public class DbLogger implements ILogger{
    public void log(String message){
        System.out.println("Database: "+ message);
    }
}
