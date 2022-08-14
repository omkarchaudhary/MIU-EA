package edu.miu.ea.springpractice.service;

public class MsSqlManager implements DBManager{

    public void connectToDB() {
        System.out.println("Connecting to MS SQL Server ...");
    }

    public void closeConnection() {
        System.out.println("Closing connection to MS SQL Server ...");
    }
}
