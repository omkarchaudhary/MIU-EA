package com.miu.ea.springprofile;

public class DatabaseService {
    private String url="Default Db";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void getConnection(){
        System.out.println("Database is connecting to "+url);
    }
    public void closDatabaseConnection(){
        System.out.println("Database connection closed from "+url);
    }
}
