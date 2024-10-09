package com.currency.converter.ui;

import com.currency.converter.service.CurrencyConverter;
import com.currency.converter.service.ConversionHistory;
import com.currency.converter.util.SaveToJSON;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static final String[] currencies = {"ARS", "BOB", "BRL", "CLP", "COP", "USD", "MXN", "EUR"};
    private static final ConversionHistory history = new ConversionHistory();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        System.out.println("Welcome to the currency converter");

        while (true) {
            System.out.println("Choose an option please:");
            System.out.println("1. Convert currency from predefined list");
            System.out.println("2. Enter currency codes manually");
            System.out.println("3. View conversion history");
            System.out.println("4. Exit");

            int option = scanner.nextInt();
            if (option == 4) {
                System.out.println("Exiting...");
                break;
            }

            if (option == 3) {
                history.displayHistory();
                continue;
            }

            String fromCurrency;
            String toCurrency;
            double amount;
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();

            if (option == 1) {
                System.out.println("Choose the source currency:");
                fromCurrency = chooseCurrency(scanner);

                System.out.println("Choose the target currency:");
                toCurrency = chooseCurrency(scanner);

                System.out.println("Enter the amount to be converted: ");
                amount = scanner.nextDouble();
            } else {
                System.out.println("Enter the source currency code (e.g., USD):");
                fromCurrency = scanner.next().toUpperCase();

                System.out.println("Enter the target currency code (e.g., EUR):");
                toCurrency = scanner.next().toUpperCase();

                System.out.println("Enter the amount to be converted:");
                amount = scanner.nextDouble();
            }

            double result = converter.convert(fromCurrency, toCurrency, amount);
            if (result != -1) {
                System.out.println("Result: " + amount + " " + fromCurrency + " = " + result + " " + toCurrency);

                history.addConversion(fromCurrency, toCurrency, amount, result, time, date);

                System.out.println("Do you want to save the conversion to a JSON file? (y/n)");
                String saveOption = scanner.next();
                if ("y".equalsIgnoreCase(saveOption)) {
                    SaveToJSON.saveToJson(fromCurrency, toCurrency, amount, result,LocalTime.now() , LocalDate.now());
                }
            }
        }

        scanner.close();
    }

    private static String chooseCurrency(Scanner scanner) {
        for (int i = 0; i < currencies.length; i++) {
            System.out.println((i + 1) + ". " + currencies[i]);
        }

        int currencyIndex = scanner.nextInt() - 1;
        if (currencyIndex < 0 || currencyIndex >= currencies.length) {
            System.out.println("Invalid option. Please try again.");
            return chooseCurrency(scanner);
        }

        return currencies[currencyIndex];
    }
}
