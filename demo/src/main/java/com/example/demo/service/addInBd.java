package com.example.demo.service;

import com.example.demo.Entity.Rates;
import com.example.demo.Entity.Dto.RatesDto;
import com.example.demo.repository.RatesRepository;

import java.util.ArrayList;

public class addInBd {
    private final RatesRepository exchangeRatesRepository;

    public addInBd(RatesRepository exchangeRatesRepository) {
        this.exchangeRatesRepository = exchangeRatesRepository;
    }

    public void AddJsonsArrayInBD(ArrayList<RatesDto> data)
    {
        for (int i=0;i< data.size();i++)
        {// переделать стримом
            Rates exchangeRates= new Rates(data.get(i).getCur_ID(), data.get(i).getCur_Name(), data.get(i).getCur_OfficialRate(), data.get(i).getCur_Abbreviation(), data.get(i).getDate(),data.get(i).getCur_Scale());
           // ExchangeRates exchangeRates= new ExchangeRates(Long.valueOf((Long) jsonObject.get("Cur_ID")).intValue(), (String) jsonObject.get("Cur_Name"), (double) jsonObject.get("Cur_OfficialRate"), (String) jsonObject.get("Cur_Abbreviation"), Long.valueOf((Long) jsonObject.get("Cur_Scale")).intValue());
            exchangeRatesRepository.save(exchangeRates);
        }
    }
}
