import java.util.HashMap;

public class Epictask extends Task {
    public HashMap<Integer, Subtask> subtasks = new HashMap<Integer, Subtask>();

    Epictask() {
        super();
    }

    Epictask(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.status = 0;
    }

}
