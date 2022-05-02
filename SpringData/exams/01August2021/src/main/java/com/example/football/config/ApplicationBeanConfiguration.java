package com.example.football.config;

import com.example.football.util.ValidatorUtil;
import com.example.football.util.ValidatorUtilImpl;
import com.example.football.util.XmlParser;
import com.example.football.util.XmlParserImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }


    @Bean
    public ValidatorUtil validationUtil() {

        return new ValidatorUtilImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    @Bean
    public XmlParser xmlParser (){
        return new XmlParserImpl();
    }
}
