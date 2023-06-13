package com.example.demo.service.interfeces;

import com.example.demo.Entity.Dto.RatesDto;

import java.net.URL;
import java.util.ArrayList;

public interface getJson {
    public ArrayList<RatesDto> getJsonsArray(URL url);
}
