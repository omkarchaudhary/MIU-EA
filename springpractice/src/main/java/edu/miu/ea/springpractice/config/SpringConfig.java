package edu.miu.ea.springpractice.config;

import edu.miu.ea.springpractice.aspect.AspectJLogging;
import edu.miu.ea.springpractice.service.*;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@Profile({"development","default"})
@ComponentScan(basePackages = "edu.miu.ea.springpractice")
public class SpringConfig {

    @Bean
    public MySqlManager mySqlManager(){
        return new MySqlManager();
    }

    @Bean
    public FileLogger fileLogger(){
        return new FileLogger();
    }

    @Bean
    public DateService dateService(){
        return new DateService();
    }

    @Bean
    public EmailSystem emailSystem(){
        return new EmailSystem(dateService());
    }

    @Bean
    public StudentCRUD studentCRUD(){
        return new StudentCRUD(mySqlManager());
    }

    @Bean
    public AspectJLogging aspectJLogging_dev(){
        return new AspectJLogging(fileLogger());
    }

    @Bean
    @Profile("production")
    public StudentCRUD studentCRUD_prod(){
        return new StudentCRUD(mySqlManager());
    }

    @Bean
    @Profile("production")
    public AspectJLogging aspectJLogging_prod(){
        return new AspectJLogging(fileLogger());
    }

}
