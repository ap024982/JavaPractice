package com.example.CurrencyCoverter.service;

import com.example.CurrencyCoverter.model.currencyConvert;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;


@Service
public class currencyConvertValue {

    public currencyConvert calculateCurrency(String from, String to, int quantity) {


        //URI uri=URI.create("http://localhost:8080/findConversionRate/{from}/to/{to}");
        HashMap<String,String> hs=new HashMap<String,String>();
        hs.put("from",from);
        hs.put("to",to);
        ResponseEntity<currencyConvert> rs=new  RestTemplate().getForEntity("http://localhost:8080/findConversionRate/{from}/to/{to}",currencyConvert.class,hs);
        currencyConvert c= rs.getBody();
        float fVal=c.getRate()*quantity;
        return new currencyConvert(from,to,quantity,c.getRate(),fVal);

    }
}
