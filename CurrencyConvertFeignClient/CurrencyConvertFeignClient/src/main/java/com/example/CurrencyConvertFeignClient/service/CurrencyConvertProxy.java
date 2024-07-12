package com.example.CurrencyConvertFeignClient.service;

import com.example.CurrencyConvertFeignClient.model.CurrencyExchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange", url="localhost:8080")
public interface CurrencyConvertProxy {

    @GetMapping("/findConversionRate/{from}/to/{to}")
    public CurrencyExchange findRate(@PathVariable String from, @PathVariable String to);


}
