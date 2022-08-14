package edu.miu.ea.springpractice.service;

public class DbLogger implements Logger{

    public void log(String message) {
        System.out.println("Database : "+message);
    }
}
