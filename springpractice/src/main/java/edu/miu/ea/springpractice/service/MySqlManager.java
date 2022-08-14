package edu.miu.ea.springpractice.service;

public class MySqlManager implements DBManager {

    public void connectToDB() {
        System.out.println("Connecting to MySQL Server ...");
    }

    public void closeConnection() {
        System.out.println("Closing connection to MySQL Server ...");
    }
}
