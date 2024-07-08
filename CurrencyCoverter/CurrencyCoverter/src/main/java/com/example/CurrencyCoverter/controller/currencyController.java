package com.example.CurrencyCoverter.controller;

import com.example.CurrencyCoverter.model.currencyConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.CurrencyCoverter.service.currencyConvertValue;

@RestController
public class currencyController {

    @Autowired
    currencyConvertValue v1;

    @GetMapping("/calculate/{from}/to/{to}/{quantity}")
    public currencyConvert calculate(@PathVariable String from, @PathVariable String to, @PathVariable int quantity){
        return  v1.calculateCurrency(from,to,quantity);
    }

}
