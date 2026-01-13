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
        String[] currency = {"PEN", "ARS", "EUR", "JPY", "KRW", "USD"};

        while (flag) {
            System.out.println("""
                -----------------------------------------------------------------------
                \t\tConversor de moneda

                \tMonedas base
                1. Sol (PEN)
                2. Peso argentino (ARS)
                3. Euro (EUR)
                4. Yen (JPY)
                5. Won surcoreano (KRW)
                6. Dólar estadounidense (USD)
                7. Salir del programa

                Ingrese el monto y el código de moneda (Ej. 23 USD, 8 JPY, 9 PEN) ---> """);
            try {
                value = inpScanner.nextLine();
                if (value.equals("7")) return false;
                index = value.indexOf(32);
                amount = Double.valueOf(value.substring(0, index));
                baseCode = ((value.substring(index)).strip());

                for (int i = 0; i < 6; i++) {
                    if (baseCode.equalsIgnoreCase(currency[i])) {
                       flag = false;
                       break;
                    }
                }

                if (flag) {
                    System.out.println("El código de moneda es incorrecto");
                }
            } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Ingrese un monto y/o código adecuados");
            }
        }

        flag = true;
        while (flag) {
            System.out.println("""
                -----------------------------------------------------------------------
                \t\tConversor de moneda

                \tMonedas objetivo
                1. Sol (PEN)
                2. Peso argentino (ARS)
                3. Euro (EUR)
                4. Yen (JPY)
                5. Won surcoreano (KRW)
                6. Dólar estadounidense (USD)
                7. Salir del programa

                Ingrese el número correspondiente de la moneda objetivo ---> """);
            try {
                option = inpScanner.nextInt();
                inpScanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                inpScanner.nextLine();
                return true;
            }
            System.out.println("-----------------------------------------------------------------------");

            switch(option) {
                case 1: {
                    if (AppConfig.verifyDifferentCode(currency, option, baseCode)) break;
                    targetCode = "PEN";
                    flag = false;
                    break;
                }
                case 2: {
                    if (AppConfig.verifyDifferentCode(currency, option, baseCode)) break;
                    targetCode = "ARS";
                    flag = false;
                    break;
                }
                case 3: {
                    if (AppConfig.verifyDifferentCode(currency, option, baseCode)) break;
                    targetCode = "EUR";
                    flag = false;
                    break;
                }
                case 4: {
                    if (AppConfig.verifyDifferentCode(currency, option, baseCode)) break;
                    targetCode = "JPY";
                    flag = false;
                    break;
                }
                case 5: {
                    if (AppConfig.verifyDifferentCode(currency, option, baseCode)) break;
                    targetCode = "KRW";
                    flag = false;
                    break;
                }
                case 6: {
                    if (AppConfig.verifyDifferentCode(currency, option, baseCode)) break;
                    targetCode = "USD";
                    flag = false;
                    break;
                }
                case 7: {
                    return false;
                }
                default: {
                    System.out.println("Opción inválida, inténtelo nuevamente.");
                }
            }
        }

        if (option >= 1 && option <= 6) {
            Client client = new Client(amount, baseCode, targetCode);
            String apiKey = AppConfig.getKey();
            String url = client.dataBaseClient.createUrl(apiKey);
            String json = client.getJson(url);
            ConversionRatesByAPI conversionRatesByAPI = AppConfig.getConversionRatesByAPI(json);
            Converter converter = new Converter(client.dataBaseClient, conversionRatesByAPI);

            System.out.println("Cantidad convertida: " + converter.makeConvertion() + " " + targetCode);
        }

        return true;
    }

    
}