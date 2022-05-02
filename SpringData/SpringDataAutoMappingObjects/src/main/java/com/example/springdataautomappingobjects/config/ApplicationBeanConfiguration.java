package com.example.springdataautomappingobjects.config;

import com.example.springdataautomappingobjects.model.dto.AddGameDto;
import com.example.springdataautomappingobjects.model.entity.Game;
import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(AddGameDto.class, Game.class).
                addMappings(mapper -> mapper.map(AddGameDto::getThumbnailUrl,Game::setImageThumbnail));

        return modelMapper;
    }
}
