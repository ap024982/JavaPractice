package com.example.currencyExchange.Controller;

import com.example.currencyExchange.model.currency;
import com.example.currencyExchange.service.currencyRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.currencyExchange.service.currencyRepo;

@RestController
public class currencyController {

    @Autowired
    currencyRepo cr;

    @Autowired
    currencyRepoImpl cpl;

    @GetMapping("/findConversionRate/{from}/to/{to}")
    public currency findRate(@PathVariable String from, @PathVariable String to){
        System.out.println("Inside Rest Controller");
        currency c1= cr.findByFromCurrencyAndToCurrency(from,to);
        return c1;
    }

    @PostMapping("/saveConversionRate")
    public currency saveDetails(@RequestBody currency s){
        return cr.save(s);
    }

}
