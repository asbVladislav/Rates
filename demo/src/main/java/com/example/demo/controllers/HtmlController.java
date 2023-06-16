package com.example.demo.controllers;

import com.example.demo.Entity.Sends.SendAll;
import com.example.demo.Entity.Sends.SendNameRateScaleAbbrev;
import com.example.demo.Entity.Sends.SendNameRateScaleAbbrevDate;
import com.example.demo.Service.getByUrl.GetTest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;




@Controller
public class HtmlController {


    private final GetTest gettest;//измени это

    public HtmlController(GetTest gettest) {
        this.gettest = gettest;
    }


    @GetMapping("/")
    public String newprod(@RequestParam( required = false,defaultValue = "start") String Type) {
        if(Type.equals("period") ) return "MainPAgePeriod";
        else return "MainPage/Date";
    }

    @PostMapping("/generateUrl")
    public String createCredit(@RequestParam String infType,@RequestParam(required = false ,defaultValue = "-1") String startDate,@RequestParam(required = false ,defaultValue = "-1") String endDate,@RequestParam(required = false ,defaultValue = "-1") String date, Model model) {
        //Type тип создаваемого массива
        // Type=1 SendAll
        //Type=2 SendNameRateScaleAbbrev
        //Type=3 SendNameRateScaleAbbrevDate
        int Type;
    StringBuilder url=new StringBuilder();
    if (infType.equals("complete"))
    {
        url.append("all");
        Type=1;
    }else {Type=2;}

        url.append("rates");
        if (date.equals("-1"))
        {
            if (Type==2) {Type=3;}
            url.append("period?startperiod=");
            url.append(startDate);
            url.append("&endperiod=");
            url.append(endDate);

        }else
        {
            url.append("?date=");
            url.append(date);

        }

        switch (Type) {
            case 1:
                ArrayList<SendAll> jsons;
                jsons = gettest.getJsonsArray1("http://localhost:8080/"+url);//перенеси в проперти
                model.addAttribute("jsons", jsons);
                return "Rates/SendAll";
            case 2:
                ArrayList<SendNameRateScaleAbbrev> jsonsNameRateScaleAbbrev;
                jsonsNameRateScaleAbbrev = gettest.getJsonsArray2("http://localhost:8080/"+url);//перенеси в проперти
                model.addAttribute("jsons", jsonsNameRateScaleAbbrev);
                return "Rates/SendNameRateScaleAbbrev";
            default:
                ArrayList<SendNameRateScaleAbbrevDate> jsonsNameRateScaleAbbrevDate;
                jsonsNameRateScaleAbbrevDate = gettest.getJsonsArray3("http://localhost:8080/"+url);//перенеси в проперти
                model.addAttribute("jsons", jsonsNameRateScaleAbbrevDate);
                return "Rates/SendNameRateScaleAbbrevDate";
        }



    }
}
