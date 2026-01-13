package com.mynsc.conversor.aplicacion;

public class DataBaseClient {
    private double amount;
    private String baseCode;
    private String targetCode;

    public DataBaseClient(double amount, String baseCode, String targetCode) {
        this.amount = amount;
        this.baseCode = baseCode;
        this.targetCode = targetCode;
    }

    public String createUrl(String apiKey) {
        return "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + baseCode + "/" + targetCode ;
    }

    public double getAmount() {
        return amount;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }
}
