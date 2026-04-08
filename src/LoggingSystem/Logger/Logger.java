package LoggingSystem.Logger;

import LoggingSystem.ENUM.LogLevel;
import LoggingSystem.LoggerAppender.LoggerAppender;
import LoggingSystem.Logs.Log;
import LoggingSystem.loggerConfig.LoggerConfig;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

public class Logger {

    private static ConcurrentHashMap<String, Logger> loggerInstances = new ConcurrentHashMap<>();

    public final String className;
    public final LoggerConfig loggerConfig;

    private Logger(String className, LoggerConfig loggerConfig) {
        this.className = className;
        this.loggerConfig = loggerConfig;
    }

    private void appendLogs(Log log) {
        for(LoggerAppender appender : loggerConfig.loggerAppenderObservers) {
            appender.append(log);
        }
    }

    public void info(String message) {
        if(LogLevel.INFO.getValue() >= loggerConfig.configLevel.getValue()) {
            Log  log = new Log(LocalDateTime.now(), message, LogLevel.INFO, Thread.currentThread().getName());
            appendLogs(log);
        }
    }

    //same to be followed for debug, error, ...

    public static Logger getInstance(String className) {
        return loggerInstances.computeIfAbsent(className, key -> new Logger(key, new LoggerConfig(LogLevel.INFO)));
    }
}
