package com.example.CurrencyCoverter.model;

import org.springframework.stereotype.Component;


import javax.persistence.Id;


@Component
public class currencyConvert {
  //  Long id;

    String from;

    String to;

   float rate;

    int quantity;

    float value;

    public currencyConvert(){};

    public currencyConvert(String from,String to,int quantity,float rate,float fval){
        this.from=from;
        this.to=to;
        this.quantity=quantity;
        this.rate=rate;
        value=fval;
    }

    /*public Long getId() {
        return id;
    }*/

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public float getRate() {
        return rate;
    }

    public float getValue() {
        return value;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
