package com.currency.converter.service;

import com.currency.converter.api.ApiHandler;

public class CurrencyConverter {
    private ApiHandler apiHandler;

    public CurrencyConverter() {
        this.apiHandler = new ApiHandler();
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        double exchangeRate = apiHandler.getExchangeRate(fromCurrency, toCurrency);
        if (exchangeRate != -1) {
            return amount * exchangeRate;
        } else {
            System.out.println("Could not retrieve exchange rate.");
            return -1;
        }
    }
}
