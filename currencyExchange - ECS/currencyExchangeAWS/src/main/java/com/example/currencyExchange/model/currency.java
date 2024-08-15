package com.example.currencyExchange.model;

import jakarta.persistence.*;

@Entity
@Table(name="currencyData")
public class currency {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromCurrency;

    private String toCurrency;

    private Float rate;

    public currency(){}

    public currency(String strFrom, String strTo, float rate ){
        fromCurrency= strFrom;
        toCurrency =strTo;
        this.rate=rate;

    }

    public Long getId() {
        return id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public Float getRate() {
        return rate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }
}
