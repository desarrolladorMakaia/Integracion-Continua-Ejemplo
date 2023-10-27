package com.Mongo.EjemploMongo.configuration;

import com.Mongo.EjemploMongo.security.OperationJwt;
import com.Mongo.EjemploMongo.security.OperationJwtImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {

    @Bean
    public OperationJwt generationToken(){
        return new OperationJwtImpl();

    }
}
