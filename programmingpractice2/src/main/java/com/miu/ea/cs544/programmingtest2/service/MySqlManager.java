package com.miu.ea.cs544.programmingtest2.service;

public class MySqlManager implements IDbManager {
    public void connectToDB(){
        System.out.println("Connecting to MYSQL Server ...");
    }
    public void closeConnection(){
        System.out.println("Closing connection to MySQL Server ...");
    }
}
