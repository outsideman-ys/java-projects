import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(Task.Priority.HIGH, "Оплатить интернет."));
        tasks.add(new Task(Task.Priority.LOW, "Сходить в парикмахерскую."));
        tasks.add(new Task(Task.Priority.MEDIUM, "Выбрать подарок подруге на ДР."));
        tasks.add(new Task(Task.Priority.MEDIUM, "Купить билеты в театр."));
        tasks.add(new Task(Task.Priority.HIGH, "Посетить вебинар по английскому языку."));
        tasks.add(new Task(Task.Priority.LOW, "Купить пылесос."));

        System.out.println("Задачи с наивысшим приоритетом на сегодня:");
        for (Task task : tasks) {
            if (task.getPriority() == Task.Priority.HIGH) {
                System.out.println(task.getDescription());
            }
        }
    }
}