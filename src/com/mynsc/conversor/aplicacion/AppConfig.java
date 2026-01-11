package com.mynsc.conversor.aplicacion;

import io.github.cdimascio.dotenv.Dotenv;

public class AppConfig {
    Dotenv dotenv = Dotenv.configure()
    .directory("./src")
            .ignoreIfMalformed()
            .ignoreIfMissing()
            .load();
    
    public String getKey() {
        return dotenv.get("API_KEY");
    }
}
