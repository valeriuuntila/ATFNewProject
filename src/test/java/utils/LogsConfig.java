package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogsConfig {

    private static Logger logger;
    // Constructor creat pentra ca obiectul la aceasta clasa sa nu poata fi creat in alta parte,
    // sa nu fie posibil de instantiat un alt obiect
    private LogsConfig() {
    }


    public static Logger getLogger(){
        if (logger == null) {
            logger = LogManager.getLogger(LogsConfig.class);
            logger.info("Logger has been initialized");
        }

        return logger;
    }

}
