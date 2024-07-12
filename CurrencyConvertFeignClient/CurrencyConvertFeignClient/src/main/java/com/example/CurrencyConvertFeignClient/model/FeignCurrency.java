package com.example.CurrencyConvertFeignClient.model;

import org.springframework.stereotype.Component;

@Component
public class FeignCurrency {
    int quantity;
    float value;
    CurrencyExchange cr;

    public FeignCurrency(){}

    public FeignCurrency(int quantity, float value, CurrencyExchange cr) {
        this.quantity = quantity;
        this.value = value;
        this.cr = cr;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public CurrencyExchange getCr() {
        return cr;
    }

    public void setCr(CurrencyExchange cr) {
        this.cr = cr;
    }
}
