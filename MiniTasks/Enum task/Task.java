public class Task {

    private Priority priority;
    private String description;

    Task(Priority priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    enum Priority {
        HIGH,
        MEDIUM,
        LOW
    }
}