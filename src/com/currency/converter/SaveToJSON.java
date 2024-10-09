package com.currency.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SaveToJSON {
    private static final String FILE_NAME = "conversion.json";

    // Método que guarda la conversión en un único archivo JSON
    public static void saveToJson(String fromCurrency, String toCurrency, double amount, double result) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Conversion> conversions = new ArrayList<>();

        // Verifica si el archivo ya existe y lee las conversiones previas
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (FileReader reader = new FileReader(FILE_NAME)) {
                Type listType = new TypeToken<List<Conversion>>() {}.getType();
                conversions = gson.fromJson(reader, listType); // Lee las conversiones existentes
            } catch (IOException e) {
                System.out.println("Error reading the JSON file: " + e.getMessage());
            }
        }

        // Agrega la nueva conversión a la lista
        Conversion newConversion = new Conversion(fromCurrency, toCurrency, amount, result);
        conversions.add(newConversion);

        // Escribe toda la lista de nuevo en el archivo
        try (FileWriter fileWriter = new FileWriter(FILE_NAME)) {
            gson.toJson(conversions, fileWriter); // Escribe todas las conversiones como una lista JSON
            System.out.println("Conversion saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving to JSON file: " + e.getMessage());
        }
    }

    // Clase interna que representa una conversión de moneda
    static class Conversion {
        private String fromCurrency;
        private String toCurrency;
        private double amount;
        private double result;

        public Conversion(String fromCurrency, String toCurrency, double amount, double result) {
            this.fromCurrency = fromCurrency;
            this.toCurrency = toCurrency;
            this.amount = amount;
            this.result = result;
        }
    }
}
