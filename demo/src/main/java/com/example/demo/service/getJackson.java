package com.example.demo.service;

import com.example.demo.Entity.Dto.RatesDto;
import com.example.demo.service.interfeces.getJson;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class getJackson implements getJson {
    @Override
    public ArrayList<RatesDto> getJsonsArray(URL url) {

        ObjectMapper objectMapper=new ObjectMapper();
        ArrayList<RatesDto> JsonArray;
        try {
            JsonArray = objectMapper.readValue(url, new TypeReference<>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return JsonArray ;


    }

}
