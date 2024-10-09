package com.currency.converter.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.currency.converter.model.Conversion;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SaveToJSON {
    private static final String FILE_NAME = "conversion.json";


    public static void saveToJson(String fromCurrency, String toCurrency, double amount, double result, LocalTime time, LocalDate date) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Conversion> conversions = new ArrayList<>();

        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (FileReader reader = new FileReader(FILE_NAME)) {
                Type listType = new TypeToken<List<Conversion>>() {
                }.getType();
                conversions = gson.fromJson(reader, listType);
            } catch (IOException e) {
                System.out.println("Error reading the JSON file: " + e.getMessage());
            }
        }

        Conversion newConversion = new Conversion(fromCurrency, toCurrency, amount, result, time.toString(), date.toString());
        conversions.add(newConversion);

        try (FileWriter fileWriter = new FileWriter(FILE_NAME)) {
            gson.toJson(conversions, fileWriter);
            System.out.println("Conversion saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving to JSON file: " + e.getMessage());
        }
    }
}
