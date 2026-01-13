package com.mynsc.conversor.modelos;

import java.util.Scanner;

import com.mynsc.conversor.aplicacion.AppConfig;

public class Menu {
    public static void printMenu() {
        Scanner inpScanner = new Scanner(System.in);

        String value = "";
        int index = 0;
        double amount = 0;
        String baseCode = "";
        String targetCode = "";
        int option = 0;

        System.out.println("""
            \t\tConversor de moneda

            \tMonedas disponibles
            1. Sol (PEN)
            2. Peso argetino (ARS)
            3. Euro (EUR)
            4. Yen (JPY)
            5. Won surcoreano (KRW)
            6. Dólar estadounidense (USD)

            Ingrese el monto y el código de moneda (Ej. 23 USD, 8 YJPY, 9 PEN) ---> """);
        value = inpScanner.nextLine();

        index = value.indexOf(32);
        amount = Double.valueOf(value.substring(0, index));
        baseCode = ((value.substring(index)).strip());

        option = inpScanner.nextInt();System.out.println("""
            \t\tConversor de moneda

            \tCódigos de monedas disponibles
            1. Sol (PEN)
            2. Peso argetino (ARS)
            3. Euro (EUR)
            4. Yen (JPY)
            5. Won surcoreano (KRW)
            6. Dólar estadounidense (USD)
            7. Salir del programa

            Ingrese el código de la moneda a la que desea convertir ---> """);
        switch(option) {
            case 1: {
                targetCode = "PEN";
            }
            case 2: {
                targetCode = "ARS";
            }
            case 3: {
                targetCode = "EUR";
            }
            case 4: {
                targetCode = "JPY";
            }
            case 5: {
                targetCode = "KRW";
            }
            case 6: {
                targetCode = "USD";
            }
            case 7: {
                break;
            }
            default: {
                System.out.println("Opción inválida, inténtelo nuevamente.");
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