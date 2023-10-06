public class Task {
    public int status;
    public String name;
    public String description;
    public int id;

    Task() {
        status = 0;
        name = "Task";
        description = "Description";
    }

    Task(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.status = 0;
        this.id = id;
    }

    public void ChangeStatus(int status) {
        this.status = status;
    }

    public void ChangeDescription(String description) {
        this.description = description;
    }

    public void ChangeName(String name) {
        this.name = name;
    }

}
