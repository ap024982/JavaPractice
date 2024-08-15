package com.example.currencyExchange.service;

import com.example.currencyExchange.model.currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface currencyRepo extends JpaRepository<currency,Long> {
    public currency findByFromCurrencyAndToCurrency(String FromCurrency, String ToCurrency);
    public currency save(currency s);
}
