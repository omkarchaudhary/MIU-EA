package com.miu.ea.cs544.programmingtest2.service;

public class FileLogger implements ILogger {
    public void log(String message){
        System.out.println("File : "+message);
    }
}
