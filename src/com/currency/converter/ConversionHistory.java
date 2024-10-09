package com.currency.converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

// Clase que almacena y muestra el historial de conversiones
public class ConversionHistory {
    private List<String> history = new ArrayList<>();

    // Agrega una conversión al historial
    public void addConversion(String fromCurrency, String toCurrency, double amount, double result, LocalTime time, LocalDate date) {



        String conversion = amount + " " + fromCurrency + " = " + result + " " + toCurrency;
        history.add(conversion);


    }

    // Muestra el historial de conversiones
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
