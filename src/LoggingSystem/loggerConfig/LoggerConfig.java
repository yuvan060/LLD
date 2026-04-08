package LoggingSystem.loggerConfig;

import LoggingSystem.ENUM.LogLevel;
import LoggingSystem.LoggerAppender.LoggerAppender;

import java.util.ArrayList;
import java.util.List;

public class LoggerConfig {
    public LogLevel configLevel;
    public final List<LoggerAppender> loggerAppenderObservers;

    public LoggerConfig(LogLevel configLevel) {
        this.configLevel = configLevel;
        this.loggerAppenderObservers = new ArrayList<>();
    }
}
