package Utilities;


import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log {
 
    //Initialize Log4j instance
    private static Logger logger= LogManager.getLogger(Log.class);

 public static void main(String[] args) {
    // Configurator.setRootLevel(Level.TRACE);
     BasicConfigurator.configure();
     logger.info("Open");
 }

    //We can use it when starting tests
    public static void startLog (String testClassName){
        logger.info("TEST STARTING...");
    }
 
    //We can use it when ending tests
    public static void endLog (String testClassName){
        logger.info("TEST ENDING...");
    }
 
    //Info Level Logs
    public static void info (String message) {
        logger.info(message);
    }
 
    //Warn Level Logs
    public static void warn (String message) {
        logger.warn(message);
    }
 
    //Error Level Logs
    public static void error (String message) {
        logger.error(message);
    }
 
    //Fatal Level Logs
    public static void fatal (String message) {
        logger.fatal(message);
    }
 
    //Debug Level Logs
    public static void debug (String message) {
        logger.debug(message);
    }


}
