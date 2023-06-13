package com.example.demo.service;

import com.example.demo.Configure.ProxyConfig;
import com.example.demo.Entity.Dto.RatesDto;
import com.example.demo.service.interfeces.getJson;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GetJacksonRestTemplate implements getJson {
    @Autowired
    ProxyConfig proxyConfig;
    @Override
    public ArrayList<RatesDto> getJsonsArray(String url) {


        RatesDto[] jsons = new RatesDto[0];

        RestTemplate restTemplate=proxyConfig.restTemplate();
        //RestTemplate restTemplate=new RestTemplate();
        jsons=restTemplate.getForObject(url,jsons.getClass());
        ArrayList<RatesDto> JsonArray = (ArrayList<RatesDto>) Arrays.stream(jsons).collect(Collectors.toList());


        return JsonArray ;

    }

}
