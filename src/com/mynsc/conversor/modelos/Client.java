package com.mynsc.conversor.modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.mynsc.conversor.aplicacion.DataBaseClient;

public class Client {
    public DataBaseClient dataBaseClient;
    
    public Client(double amount, String baseCode, String targetCode) {
        dataBaseClient = new DataBaseClient(amount, baseCode, targetCode);
    }

    public String getJson (String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
             .uri(URI.create(url))
             .build();
        try {
            HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return json;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al establecer conexión");
        }
    }

    
}