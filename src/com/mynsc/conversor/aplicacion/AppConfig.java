package com.mynsc.conversor.aplicacion;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mynsc.conversor.modelos.ConversionRatesByAPI;

import io.github.cdimascio.dotenv.Dotenv;

public class AppConfig {
    public static String getKey() {
        Dotenv dotenv = Dotenv.configure()
            .directory("./src")
            .ignoreIfMalformed()
            .ignoreIfMissing()
            .load();
        return dotenv.get("API_KEY");
    }

    public static ConversionRatesByAPI getConversionRatesByAPI(String json) {
        Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()    
            .create();

        return gson.fromJson(json, ConversionRatesByAPI.class);
    }
}
