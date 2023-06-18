package com.example.demo.controllers;


import com.example.demo.Entity.Dto.CurrencyDto;
import com.example.demo.Entity.Rates;
import com.example.demo.Entity.Sends.SendAll;
import com.example.demo.Entity.Sends.SendNameRateScaleAbbrev;
import com.example.demo.Entity.Sends.SendNameRateScaleAbbrevDate;
import com.example.demo.Repository.CurrencyRepository;
import com.example.demo.Repository.RatesRepository;
import com.example.demo.Service.DateParser;
import com.example.demo.Service.db.AddArrayListCurrencyInBd;
import com.example.demo.Service.getByUrl.GetArrayListCurrencyDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@Tag(name="Контроллер добавления", description="Контроллер для добавления данных в БД")
@RestController
public class AddInDbController
{
    private final AddArrayListCurrencyInBd addArrayListCurrencyInBd;

    private final GetArrayListCurrencyDto getArrayListCurrencyDto;



    Logger logger;

    @Value("${value.url.currency}")
    private String currencyUrl;




    @Operation(
            summary = "Добавление полного перечня валют",
            description = "Данное обновление делается один раз, в начале работы программы"
    )
    @PostMapping("/currency")
    public String getCurrencies() {
        try {
        ArrayList<CurrencyDto> jsons=getArrayListCurrencyDto.getJsonsArray(currencyUrl);
        logger.info("Currency get from url ");
        addArrayListCurrencyInBd.AddJsonsArrayInBD(jsons);
        logger.info("Currency add into database ");
            return "currencies added successfully";
        }
        catch (Throwable e){logger.error(e.getMessage());
            return "currencies NOT added successfully";}

    }


    public AddInDbController(AddArrayListCurrencyInBd addArrayListCurrencyInBd , GetArrayListCurrencyDto getArrayListCurrencyDto) {
        this.addArrayListCurrencyInBd = addArrayListCurrencyInBd;
        this.getArrayListCurrencyDto = getArrayListCurrencyDto;
        logger = LoggerFactory.getLogger("Controller Logger");
    }
}
