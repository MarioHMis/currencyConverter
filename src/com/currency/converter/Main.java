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
            String sourceCurrency = scanner.next().toUpperCase();
            System.out.println("Enter the target currency (e.g., EUR): ");
            String toCurrency = scanner.next().toUpperCase();
            System.out.println("Enter the amount to be converted: ");
            double amount = scanner.nextDouble();

            double result = converter.convert(fromCurrency, toCurrency, amount);
            if(result != -1) {
                System.out.println(amount + " " + sourceCurrency + " " + toCurrency);
            }else {
                System.out.println("Invalid input");
            }
        }
        scanner.close();
    }
}
