package com.sineadmcl.logging;

import java.util.logging.Logger;

public class UtilityLogger {

  private Logger logger;

  public UtilityLogger() {
    logger = Logger.getAnonymousLogger();
  }

  public void logInfo(String message){
    logger.info(message);
  }

  public void logError(String message){
    logger.severe(message);
  }


}
