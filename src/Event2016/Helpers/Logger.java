package Event2016.Helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger
{
    private LogLevel minLogLevel;
    private final DateFormat loggingDateFormat;

    public Logger(LogLevel minLogLevel)
    {
        loggingDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        setMinLogLevel(minLogLevel);
    }

    public void logMessage(String message)
    {
        logMessage(message, LogLevel.DEBUG);
    }

    public void logMessage(String message, LogLevel logLevel)
    {
        // Only log the message if it's equal or larger then the minimum log level
        if(logLevel.isEqualOrAbove(getMinLogLevel())) {
            System.out.println(String.format("[%s] %s", getCurrentDateTime(), message));
        }
    }

    private String getCurrentDateTime()
    {
        return loggingDateFormat.format(new Date());
    }

    private LogLevel getMinLogLevel()
    {
        return minLogLevel;
    }

    private Logger setMinLogLevel(LogLevel minLogLevel)
    {
        this.minLogLevel = minLogLevel;
        return this;
    }
}
