package com.mynsc.conversor.modelos;

import java.util.Scanner;

import com.mynsc.conversor.aplicacion.AppConfig;

public class Menu {
    public static void printMenu() {
        Scanner inpScanner = new Scanner(System.in);

        String value = "";
        int index = 0;
        int amount = 0;
        String baseCode = "";
        String targetCode = "";
        int option = 0;

        System.out.println("Ingresa tu moneda:");
        value = inpScanner.nextLine();

        index = value.indexOf(32);
        amount = Integer.valueOf(value.substring(0, index));
        baseCode = ((value.substring(index)).strip());

        System.out.println("Codigos: ");
        option = inpScanner.nextInt();
        switch(option) {
            case 1: {
                targetCode = "PEN";

            }
            case 2: {

            }
            default: {

            }
        }

        Client client = new Client(amount, baseCode, targetCode);
        String apiKey = AppConfig.getKey();
        String url = client.dataBaseClient.createUrl(apiKey);
        String json = client.getJson(url);
        ConversionRatesByAPI conversionRatesByAPI = AppConfig.getConversionRatesByAPI(json);
        Converter converter = new Converter(client.dataBaseClient, conversionRatesByAPI);

        System.out.println("Retorno ->" + converter.makeConvertion());


        inpScanner.close();
    }

    
}