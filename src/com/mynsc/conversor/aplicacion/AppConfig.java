package com.mynsc.conversor.aplicacion;

import io.github.cdimascio.dotenv.Dotenv;

public class AppConfig {
    private Dotenv dotenv = Dotenv.configure()
        .directory("./src")
        .ignoreIfMalformed()
        .ignoreIfMissing()
        .load();
    
    public String getKey() {
        return dotenv.get("API_KEY");
    }
}
