package com.example.demo.service;

import com.example.demo.Entity.Currency;
import com.example.demo.Entity.Dto.CurrencyDto;
import com.example.demo.Entity.Dto.RatesDto;
import com.example.demo.Entity.Rates;
import com.example.demo.repository.CurrencyRepository;
import com.example.demo.repository.RatesRepository;

import java.util.ArrayList;
import java.util.stream.Stream;

public class addInBd2 {
    private final CurrencyRepository currencyRepository;

    public addInBd2(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public void AddJsonsArrayInBD(ArrayList<CurrencyDto> data)
    {



        data.stream().map(d -> new Currency
                (
                d.getCur_ID(), d.getCur_ParentID(),
                d.getCur_Code(), d.getCur_Abbreviation(),
                d.getCur_Name(), d.getCur_Name_Bel(),
                d.getCur_Name_Eng(), d.getCur_QuotName(),
                d.getCur_QuotName_Bel(), d.getCur_QuotName_Eng(),
                d.getCur_NameMulti(), d.getCur_Name_BelMulti(),
                d.getCur_Name_EngMulti(), d.getCur_Scale(),
                d.getCur_Periodicity(), d.getCur_DateStart(),
                d.getCur_DateEnd()
                )
        ).forEach(currencyRepository::save);
//        for (int i=0;i< data.size();i++)
//        {// переделать стримом
//            Currency currency= new Currency(data.get(i).getCur_ID(),data.get(i).getCur_ParentID(),data.get(i).getCur_Code(),data.get(i).getCur_Abbreviation(),data.get(i).getCur_Name(),data.get(i).getCur_Name_Bel(),data.get(i).getCur_Name_Eng(),data.get(i).getCur_QuotName(),data.get(i).getCur_QuotName_Bel(), data.get(i).getCur_QuotName_Eng(),data.get(i).getCur_NameMulti(),data.get(i).getCur_Name_BelMulti(),data.get(i).getCur_Name_EngMulti(),data.get(i).getCur_Scale(),data.get(i).getCur_Periodicity(),data.get(i).getCur_DateStart(),data.get(i).getCur_DateEnd());
//           // ExchangeRates exchangeRates= new ExchangeRates(Long.valueOf((Long) jsonObject.get("Cur_ID")).intValue(), (String) jsonObject.get("Cur_Name"), (double) jsonObject.get("Cur_OfficialRate"), (String) jsonObject.get("Cur_Abbreviation"), Long.valueOf((Long) jsonObject.get("Cur_Scale")).intValue());
//            currencyRepository.save(currency);
//        }
    }
}
