package com.mynsc.conversor.modelos;

import java.util.Scanner;

import com.mynsc.conversor.aplicacion.AppConfig;

public class Menu {
    public static boolean printMenu(Scanner inpScanner) {

        String value = "";
        int index = 0;
        double amount = 0;
        String baseCode = "";
        String targetCode = "";
        int option = 0;
        boolean flag = true;

        while (flag) {
            System.out.println("""
                -----------------------------------------------------------------------
                \t\tConversor de moneda

                \tMonedas disponibles
                1. Sol (PEN)
                2. Peso argetino (ARS)
                3. Euro (EUR)
                4. Yen (JPY)
                5. Won surcoreano (KRW)
                6. Dólar estadounidense (USD)

                Ingrese el monto y el código de moneda (Ej. 23 USD, 8 YJPY, 9 PEN) ---> """);
            try {
                value = inpScanner.nextLine();
                index = value.indexOf(32);
                amount = Double.valueOf(value.substring(0, index));
                baseCode = ((value.substring(index)).strip());
                System.out.println("-----------------------------------------------------------------------");
                flag = false;
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Ingrese  un monto y código adecuados");
            }
        }

        System.out.println("""
            -----------------------------------------------------------------------
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
        option = inpScanner.nextInt();
        System.out.println("-----------------------------------------------------------------------");

        switch(option) {
            case 1: {
                targetCode = "PEN";
                break;
            }
            case 2: {
                targetCode = "ARS";
                break;
            }
            case 3: {
                targetCode = "EUR";
                break;
            }
            case 4: {
                targetCode = "JPY";
                break;
            }
            case 5: {
                targetCode = "KRW";
                break;
            }
            case 6: {
                targetCode = "USD";
                break;
            }
            case 7: {
                return false;
            }
            default: {
                System.out.println("Opción inválida, inténtelo nuevamente.");
            }
        }

        if (option != 7)  {
            Client client = new Client(amount, baseCode, targetCode);
            String apiKey = AppConfig.getKey();
            String url = client.dataBaseClient.createUrl(apiKey);
            String json = client.getJson(url);
            ConversionRatesByAPI conversionRatesByAPI = AppConfig.getConversionRatesByAPI(json);
            Converter converter = new Converter(client.dataBaseClient, conversionRatesByAPI);

            System.out.println("Cantidad convertida: " + converter.makeConvertion());
        }

        return true;
    }

    
}