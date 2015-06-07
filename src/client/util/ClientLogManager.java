package client.util;

import java.io.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.Level;

public enum ClientLogManager {
  INSTANCE;

  /** The logger used throughout the project. */
  private static Logger logger = Logger.getLogger("client");

  public static void initLogs() {
    File logDir = new File("logs");
    if (!logDir.exists()) {
      try {
        logDir.mkdir();
      } catch (SecurityException e) {
        System.out.println("ERROR: unable to create log directory...");
      }
    }

    try {
      FileInputStream is = new FileInputStream("logging.properties");
      LogManager.getLogManager().readConfiguration(is);
      logger = Logger.getLogger("client");
    } catch (IOException e) {
      System.out.println("ERROR: unable to load logging properties file...");
    }
    logger.info("===============Initialized " + logger.getName() + " log...");
  }

  public static Logger getLogger() {
    return logger;
  }
}
