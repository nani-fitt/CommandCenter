package Utilities;


import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log {
 
    //Initialize Log4j instance
    private static Logger Log= LogManager.getLogger(Log.class.getName());

 public static void main(String[] args) {
    // Configurator.setRootLevel(Level.TRACE);
     BasicConfigurator.configure();
    Log.info("Open");
 }

    //We can use it when starting tests
    public static void startLog (String testClassName){
        Log.info("TEST STARTING...");
    }
 
    //We can use it when ending tests
    public static void endLog (String testClassName){
        Log.info("TEST ENDING...");
    }
 
    //Info Level Logs
    public static void info (String message) {
        Log.info(message);
    }
 
    //Warn Level Logs
    public static void warn (String message) {
        Log.warn(message);
    }
 
    //Error Level Logs
    public static void error (String message) {
        Log.error(message);
    }
 
    //Fatal Level Logs
    public static void fatal (String message) {
        Log.fatal(message);
    }
 
    //Debug Level Logs
    public static void debug (String message) {
        Log.debug(message);
    }


}
