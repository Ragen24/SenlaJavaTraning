package com.senlatask.bookstore.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Exception logger class
 * Uses apache log4j 2 logger
 */
public abstract class ExceptionLogger {
    private static Logger logger = LogManager.getLogger(ExceptionLogger.class.getName());

    /**
     * Log errors to file
     * @param level — error level
     * @param string — message
     */
    public static void log(Level level, String string) {
        logger.log(level, string);
    }
}
