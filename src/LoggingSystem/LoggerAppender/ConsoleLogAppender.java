package LoggingSystem.LoggerAppender;

import LoggingSystem.LogFormatter.LogFormatter;
import LoggingSystem.Logs.Log;

public class ConsoleLogAppender implements LoggerAppender{
    public LogFormatter logFormatter;

    public ConsoleLogAppender(LogFormatter logFormatter) {
        this.logFormatter = logFormatter;
    }

    @Override
    public void append(Log log) {
        String logToBeConsoled = logFormatter.formatLogs(log.message);
        System.out.println(logToBeConsoled);
    }
}
