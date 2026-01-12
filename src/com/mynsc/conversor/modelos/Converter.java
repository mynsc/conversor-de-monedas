package com.mynsc.conversor.modelos;

import com.mynsc.conversor.aplicacion.DataBaseClient;

public class Converter extends DataBaseClient {
    double conversionRate;

    public Converter(DataBaseClient dataBaseClient, ConversionRatesByAPI  conversionRatesByAPI) {
        super(dataBaseClient.getAmount(), dataBaseClient.getBaseCode(), dataBaseClient.getTargetCode());
        this.conversionRate = Double.parseDouble(conversionRatesByAPI.conversion_rate());
    }

    public double makeConvertion() {
        System.out.println(conversionRate + " y " + (double) (getAmount()));
        return conversionRate * (double) (getAmount());
    }

    @Override
    public int getAmount() {
        return super.getAmount();
    }
}
