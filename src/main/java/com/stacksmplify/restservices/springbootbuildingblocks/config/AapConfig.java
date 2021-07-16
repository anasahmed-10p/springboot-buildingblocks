package com.stacksmplify.restservices.springbootbuildingblocks.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AapConfig {

    @Bean
    public ModelMapper getModelMapper()
    {
        return new ModelMapper();
    }
}
