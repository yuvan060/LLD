package LoggingSystem.Logs;

import LoggingSystem.ENUM.LogLevel;

import java.time.LocalDateTime;

public class Log {
    public final LocalDateTime timeStamp;
    public final String message;
    public final LogLevel logLevel;
    public final String threadName;

    public Log(LocalDateTime timeStamp, String message, LogLevel logLevel, String threadName) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.logLevel = logLevel;
        this.threadName = threadName;
    }
}
