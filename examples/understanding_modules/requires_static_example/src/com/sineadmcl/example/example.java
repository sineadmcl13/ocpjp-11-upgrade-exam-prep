package com.sineadmcl.example;

import java.util.logging.Logger;

public class example {

  public static void main(String [] args){
    try {
      Logger logger = Logger.getLogger("javaLogger");
      logger.info("We found the java.logging module at runtime");
    } catch (Throwable ex){
      System.out.println("We did not find the java.logging module at runtime");
    }
  }
}
