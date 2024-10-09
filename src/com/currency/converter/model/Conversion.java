package com.currency.converter.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Conversion {
    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double result;
    private String time;
    private String date;


    public Conversion(String fromCurrency, String toCurrency, double amount, double result, String time, String date) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.result = result;
        this.time = time;
        this.date = date;
    }



    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public double getResult() {
        return result;
    }
}
