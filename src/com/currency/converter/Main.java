package com.currency.converter;

import java.util.Scanner;

public class Main {
    private static final String[] currencies = {"ARS", "BOB", "BRL", "CLP", "COP", "USD", "MXN", "EUR"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        System.out.println("Welcome to the currency converter");

        while (true) {
            System.out.println("Choose an option please:");
            System.out.println("1. Convert currency from predefined list");
            System.out.println("2. Enter currency codes manually");
            System.out.println("3. Exit");

            int option = scanner.nextInt();
            if (option == 3) {
                System.out.println("Exiting...");
                break;
            }

            String fromCurrency;
            String toCurrency;
            double amount;

            if (option == 1) {
                System.out.println("Choose the source currency:");
                fromCurrency = chooseCurrency(scanner);

                System.out.println("Choose the target currency:");
                toCurrency = chooseCurrency(scanner);

                System.out.println("Enter the amount to be converted: ");
                amount = scanner.nextDouble();
            } else if (option == 2) {
                System.out.println("Enter the source currency (e.g., USD): ");
                fromCurrency = scanner.next().toUpperCase();
                System.out.println("Enter the target currency (e.g., EUR): ");
                toCurrency = scanner.next().toUpperCase();
                System.out.println("Enter the amount to be converted: ");
                amount = scanner.nextDouble();
            } else {
                System.out.println("Invalid option.");
                continue;
            }

            double result = converter.convert(fromCurrency, toCurrency, amount);
            if (result != -1) {
                System.out.println(amount + " " + fromCurrency + " = " + result + " " + toCurrency);
            } else {
                System.out.println("Invalid input or could not retrieve exchange rate.");
            }
        }
        scanner.close();
    }

    private static String chooseCurrency(Scanner scanner) {
        for (int i = 0; i < currencies.length; i++) {
            System.out.println((i + 1) + ". " + currencies[i]);
        }

        int choice = scanner.nextInt();
        while (choice < 1 || choice > currencies.length) {
            System.out.println("Invalid choice. Please select a valid currency.");
            choice = scanner.nextInt();
        }

        return currencies[choice - 1];
    }
}
