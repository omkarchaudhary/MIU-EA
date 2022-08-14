package com.miu.ea.cs544.programmingtest2.config;

import com.miu.ea.cs544.programmingtest2.aspect.LoggingAspect;
import com.miu.ea.cs544.programmingtest2.aspect.TransactionAspect;
import com.miu.ea.cs544.programmingtest2.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableAspectJAutoProxy
public class SpringConfig {
    @Bean
    public DateService dateService(){
        return new DateService();
    }
    @Bean
    @Profile("prod")
    public DbLogger dbLogger(){
        return  new DbLogger();
    }
    @Bean
    public EmailSystem emailSystem(){
        return  new EmailSystem();
    }
    @Bean
    public LoggingAspect loggingAspect(){
        return  new LoggingAspect();
    }
    @Bean
    public TransactionAspect transactionAspect(){
        return new TransactionAspect();
    }
    @Bean
    @Profile({"dev","default"})
    public FileLogger fileLogger(){
        return  new FileLogger();
    }
    @Bean
    @Profile("prod")
    public MsSqlManager msSqlManager(){
        return  new MsSqlManager();
    }
    @Bean
    @Profile({"dev","default"})
    public MySqlManager mySqlManager(){
        return new MySqlManager();
    }
    @Bean
    @Profile({"dev","default"})
    public StudentCRUD studentCRUDForDev(){
        return new StudentCRUD(mySqlManager());
    }
    @Bean
    @Profile("prod")
    public StudentCRUD studentCRUDForProd(){
        return  new StudentCRUD(msSqlManager());
    }
}
