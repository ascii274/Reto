package com.ascii274.reto.helper;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * - For MongoDb log, when it appears in console
 * - For now not needed.
 * - if needed, put constructor contents in main.
 */
public class ConfigLogger {

    public ConfigLogger() {
        Logger.getLogger("org.mongodb.driver.connection").setLevel(Level.OFF);
        Logger.getLogger("org.mongodb.driver.management").setLevel(Level.OFF);
        Logger.getLogger("org.mongodb.driver.cluster").setLevel(Level.OFF);
        Logger.getLogger("org.mongodb.driver.protocol.insert").setLevel(Level.OFF);
        Logger.getLogger("org.mongodb.driver.protocol.query").setLevel(Level.OFF);
        Logger.getLogger("org.mongodb.driver.protocol.update").setLevel(Level.OFF);
    }

}
