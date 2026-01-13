package com.mynsc.conversor.modelos;

import com.mynsc.conversor.aplicacion.DataBaseClient;

public class Converter extends DataBaseClient {
    private double conversionRate;

    public Converter(DataBaseClient dataBaseClient, ConversionRatesByAPI  conversionRatesByAPI) {
        super(dataBaseClient.getAmount(), dataBaseClient.getBaseCode(), dataBaseClient.getTargetCode());
        this.conversionRate = conversionRatesByAPI.conversion_rate();
    }

    public double makeConvertion() {
        System.out.println(conversionRate + " y " + getAmount());
        return conversionRate * getAmount();
    }

    @Override
    public double getAmount() {
        return super.getAmount();
    }
}