package com.miu.ea.cs544.programmingtest2.service;

public class MsSqlManager implements IDbManager {
    public void connectToDB(){
        System.out.println("Connecting to MS SQL Server ...");
    }
    public void closeConnection(){
        System.out.println("Closing connection to MS SQL Server ...");
    }
}
