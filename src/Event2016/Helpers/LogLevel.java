package Event2016.Helpers;

public enum LogLevel
{
    DEBUG(0),
    INFO(1),
    WARN(2),
    ERROR(3),
    VICTORY(4);

    private int severity;

    LogLevel(int severity)
    {
        setSeverity(severity);
    }

    public boolean isEqualOrAbove(LogLevel logLevel)
    {
        return this.getSeverity() >= logLevel.getSeverity();
    }

    public int getSeverity()
    {
        return severity;
    }

    public LogLevel setSeverity(int severity)
    {
        this.severity = severity;
        return this;
    }
}
