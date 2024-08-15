package com.example.currencyExchange.service;

import com.example.currencyExchange.model.currency;
import org.springframework.stereotype.Service;

@Service
public class currencyRepoImpl {
    currencyRepo r1;
    public currency saveData(currency s){
        return r1.save(s);
    }
}
