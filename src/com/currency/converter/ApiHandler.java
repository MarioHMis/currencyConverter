package com.currency.converter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

public class ApiHandler {
    private static final String API_KEY = "9e87c568202423108f616295";  // Asegúrate de usar la clave correcta.
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    // Método para obtener la tasa de cambio desde la API
    public double getExchangeRate(String fromCurrency, String toCurrency) {
        try {
            URL url = new URL(BASE_URL + fromCurrency + "/" + toCurrency); // Construye la URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // Verifica si la respuesta es exitosa
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                System.out.println("Error: could not connect to the API. Response code: " + responseCode);
                return -1;
            }

            // Parsear la respuesta de la API
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            Gson gson = new Gson();
            RateResponse response = gson.fromJson(reader, RateResponse.class);

            reader.close(); // Cierra el lector

            if ("success".equals(response.getResult())) {
                return response.getConversionRate(); // Devuelve la tasa de cambio
            } else {
                System.out.println("Error: could not get exchange rate. API result: " + response.getResult());
                return -1;
            }

        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
            return -1; // Retorna -1 en caso de error
        }
    }
}
