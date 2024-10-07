package com.currency.converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        System.out.println("Welcome to the currency converter");

        while (true) {
            System.out.println("Choose an option please:");
            System.out.println("1. Convert Currency");
            System.out.println("2. Exit");

            int option = scanner.nextInt();
            if (option == 2) {
                System.out.println("Exiting...");
                break;
            }

            System.out.println("Enter the source currency (e.g., USD): ");
            String fromCurrency = scanner.next().toUpperCase();
            System.out.println("Enter the target currency (e.g., GBP): ");
            String toCurrency = scanner.next().toUpperCase();
            System.out.println("Enter the amount to be converted: ");
            double amount = scanner.nextDouble();

            double result = converter.convert(fromCurrency, toCurrency, amount);
            if(result != -1) {
                System.out.println(amount + " " + fromCurrency + " = " + result + " " + toCurrency);
            } else {
                System.out.println("Invalid input or could not retrieve exchange rate.");
            }
        }
        scanner.close();
    }
}
