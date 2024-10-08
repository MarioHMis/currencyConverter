package com.currency.converter;

// Clase encargada de manejar la lógica de conversión
public class CurrencyConverter {
    private ApiHandler apiHandler;

    public CurrencyConverter() {
        this.apiHandler = new ApiHandler(); // Inicia el manejador de la API
    }

    // Método para convertir la moneda
    public double convert(String fromCurrency, String toCurrency, double amount) {
        double exchangeRate = apiHandler.getExchangeRate(fromCurrency, toCurrency);
        if (exchangeRate != -1) {
            return amount * exchangeRate; // Realiza la conversión
        } else {
            System.out.println("Could not retrieve exchange rate.");
            return -1; // Si no se puede obtener la tasa de cambio
        }
    }
}
