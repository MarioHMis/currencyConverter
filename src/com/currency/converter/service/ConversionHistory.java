package com.currency.converter.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConversionHistory {
    private List<String> history = new ArrayList<>();

    public void addConversion(String fromCurrency, String toCurrency, double amount, double result, LocalTime time, LocalDate date) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = timeFormatter.format(time);

        String conversion = amount + " " + fromCurrency + " = " + result + " " + toCurrency + " " + "-" + " " + formattedTime + "," +  " " + date;
        history.add(conversion);
    }

    public void displayHistory() {
        if (history.isEmpty()) {
            System.out.println("No conversions yet.");
        } else {
            System.out.println("Conversion History:");
            for (String entry : history) {
                System.out.println(entry);
            }
        }
    }
}
