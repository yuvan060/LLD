package LoggingSystem.ENUM;

public enum LogLevel {
    DEBUG(1),
    INFO(2),
    WARN(3),
    ERROR(4);

    private final Integer value;

    LogLevel(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
