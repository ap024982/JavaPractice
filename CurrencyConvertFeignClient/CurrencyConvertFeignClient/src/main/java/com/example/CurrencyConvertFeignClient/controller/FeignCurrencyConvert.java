package com.example.CurrencyConvertFeignClient.controller;

import com.example.CurrencyConvertFeignClient.model.CurrencyExchange;
import com.example.CurrencyConvertFeignClient.model.FeignCurrency;
import com.example.CurrencyConvertFeignClient.service.CurrencyConvertProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignCurrencyConvert {

    @Autowired
    CurrencyConvertProxy cp;

    @GetMapping("/convertcurrency/from/{from}/to/{to}/quantity/{quantity}")
    public FeignCurrency convert(@PathVariable String from, @PathVariable String to, @PathVariable int quantity){

        CurrencyExchange cr=cp.findRate(from,to);
        float fval=cr.getRate() * quantity;
        return new FeignCurrency(quantity,fval,cr);

    }
}
