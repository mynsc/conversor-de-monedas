package com.mynsc.conversor.aplicacion;

public class DataBaseClient {
    public String createUrl(String apiKey) {
        return "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";
    }
}
