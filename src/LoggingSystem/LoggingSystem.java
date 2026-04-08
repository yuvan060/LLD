package LoggingSystem;

public class LoggingSystem {
    /*
    We need to design a logging system, that accepts the message & log level
    append the logs to the destination, destinations can be different & multiple destinations are allowed
    The system should support multiple log levels

     Entities:
     Enum - LogLevel - value as attribute
     Logs - LogLevel, Message, TimeStamp, Thread, Class
     Interface - LogAppender - write(Log); implemented by FileAppender, ConsoleAppender, ....
     Interface - LoggerFormater - format(Log); implemented by JSONFormatter, TextFormatter
     LoggerConfig - className, level, List<LogAppender>
     Logger - singleton class - static ConcurrentHashMap<String, Logger> instances,LoggerConfig; info, debug, error, fatal, warn

     */
}
