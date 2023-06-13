package com.example.demo.controllers;


import com.example.demo.Configure.ProxyConfig;
import com.example.demo.Entity.Dto.CurrencyDto;
import com.example.demo.Entity.Rates;
import com.example.demo.Entity.Dto.RatesDto;
import com.example.demo.repository.CurrencyRepository;
import com.example.demo.repository.RatesRepository;
import com.example.demo.service.*;
import com.example.demo.service.interfeces.getJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

@Controller
@ResponseBody
public class RestContrl
{
    private final RatesRepository RatesRepository;
    private final CurrencyRepository currencyRepository;

    public RestContrl(RatesRepository exchangeRatesRepository, CurrencyRepository currencyRepository) {
        this.RatesRepository = exchangeRatesRepository;
        this.currencyRepository = currencyRepository;
    }

    @RequestMapping("/")
public String getJson( )
{
    try {
        URL url = new URL("https://api.nbrb.by/exrates/rates/431");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {
            String inline = "";
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }
            scanner.close();
            System.out.println(inline);



            //JSONParser jsonParser=new JSONParser(inline);
            JSONObject json= (JSONObject) new JSONParser().parse(inline);
            System.out.println(json.get("Cur_Abbreviation"));
            System.out.println("------------------------------");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return "poka chto nichego";
}

    @RequestMapping("/mas")
    public String getData() {


        JSONArray json = null;
            getJson getJson=new getGooglecodeJsonSimple();
            // json = (PojoJson) getJson.getJsonsArray( new URL("https://api.nbrb.by/exrates/rates?periodicity=0"));
            json = (JSONArray) getJson.getJsonsArray(  "https://api.nbrb.by/exrates/rates?periodicity=0");



             for (int i=0;i< json.size();i++)
             {
                 JSONObject jsonObject= (JSONObject) json.get(i);
                 System.out.print((String) jsonObject.get("Date"));
                 System.out.println( jsonObject.get("Date").getClass());
               //  Rates exchangeRates= new Rates(Long.valueOf((Long) jsonObject.get("Cur_ID")).intValue(), (String) jsonObject.get("Cur_Name"), (double) jsonObject.get("Cur_OfficialRate"), (String) jsonObject.get("Cur_Abbreviation"), Long.valueOf((Long) jsonObject.get("Cur_Scale")).intValue());
                // RatesRepository.save(exchangeRates);
             }



        return "poka chto nichego, no s massivom";
    }

    @RequestMapping("/mas2")
    public String getData2() {

        ArrayList<RatesDto> jsons;
        getJson getJson = new getJackson();
        jsons = getJson.getJsonsArray("https://api.nbrb.by/exrates/rates?periodicity=0");// вынести в проперти





        addInBd DataBase=new addInBd(RatesRepository);
        DataBase.AddJsonsArrayInBD(jsons);




        return "poka chto nichego, no s jackson";
    }

    @RequestMapping("/mas3")
    public String getData3() {


        ArrayList<CurrencyDto> jsons;
        try {
            getJackson2 getJson=new getJackson2();
            jsons =  getJson.getJsonsArray( new URL("https://api.nbrb.by/exrates/currencies"));// вынести в проперти

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
System.out.println(jsons);
        addInBd2 DataBase=new addInBd2(currencyRepository);
        DataBase.AddJsonsArrayInBD(jsons);




        return "poka chto nichego, no s jackson i currency";
    }

    @RequestMapping("/mas4")
    public String getData4() {



getJson getJson=new GetJacksonRestTemplate();
System.out.println(getJson.getJsonsArray("https://api.nbrb.by/exrates/rates?periodicity=0"));




        return "poka chto nichego, no s jackson";
    }
}
