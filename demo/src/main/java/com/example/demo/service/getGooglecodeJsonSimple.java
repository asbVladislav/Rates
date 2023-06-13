package com.example.demo.service;

import com.example.demo.Entity.Dto.RatesDto;
import com.example.demo.service.interfeces.getJson;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class getGooglecodeJsonSimple implements getJson {
    @Override
    public ArrayList<RatesDto> getJsonsArray(String urlStr) {
        URL url= null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        JSONArray json = null;
        try {
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



                json= (JSONArray) new JSONParser().parse(inline);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }


        return json ;
    }
}
