package com.example.demo.service;

import com.example.demo.Entity.Currency;
import com.example.demo.Entity.Dto.CurrencyDto;
import com.example.demo.Entity.Dto.RatesDto;
import com.example.demo.Entity.Rates;
import com.example.demo.repository.CurrencyRepository;
import com.example.demo.repository.RatesRepository;

import java.util.ArrayList;

public class addInBd2 {
    private final CurrencyRepository currencyRepository;

    public addInBd2(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public void AddJsonsArrayInBD(ArrayList<CurrencyDto> data)
    {
        for (int i=0;i< data.size();i++)
        {// переделать стримом
            Currency currency= new Currency(data.get(i).getCur_ID(),data.get(i).getCur_ParentID(),data.get(i).getCur_Code(),data.get(i).getCur_Abbreviation(),data.get(i).getCur_Name(),data.get(i).getCur_Name_Bel(),data.get(i).getCur_Name_Eng(),data.get(i).getCur_QuotName(),data.get(i).getCur_QuotName_Bel(), data.get(i).getCur_QuotName_Eng(),data.get(i).getCur_NameMulti(),data.get(i).getCur_Name_BelMulti(),data.get(i).getCur_Name_EngMulti(),data.get(i).getCur_Scale(),data.get(i).getCur_Periodicity(),data.get(i).getCur_DateStart(),data.get(i).getCur_DateEnd());
           // ExchangeRates exchangeRates= new ExchangeRates(Long.valueOf((Long) jsonObject.get("Cur_ID")).intValue(), (String) jsonObject.get("Cur_Name"), (double) jsonObject.get("Cur_OfficialRate"), (String) jsonObject.get("Cur_Abbreviation"), Long.valueOf((Long) jsonObject.get("Cur_Scale")).intValue());
            currencyRepository.save(currency);
        }
    }
}
