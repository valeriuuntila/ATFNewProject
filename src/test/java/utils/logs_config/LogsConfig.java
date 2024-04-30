package utils.logs_config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogsConfig {

    private static Logger logger;
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
