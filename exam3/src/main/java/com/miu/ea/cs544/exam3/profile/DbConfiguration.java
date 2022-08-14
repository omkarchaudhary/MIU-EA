package com.miu.ea.cs544.exam3.profile;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
@Configuration
@ConfigurationProperties("spring.datasource")
public class DbConfiguration {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Bean
    @Profile("dev")
    public String devDataBaseConnection(){
        System.out.println("Development database is connected to H2 Database ");
        return "Connection successfull";
    }
    @Bean
    @Profile("prod")
    public String prodDataBaseConnection(){
        System.out.println("Production database is connected to MySQL Database ");
        return "Connection successfull";
    }
}
