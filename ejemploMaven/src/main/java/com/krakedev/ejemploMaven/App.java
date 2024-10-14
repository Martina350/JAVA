package com.krakedev.ejemploMaven;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Este es un mensaje de INFO.");
        logger.debug("Este es un mensaje de DEBUG.");
        logger.error("Este es un mensaje de ERROR.");
    }
}
