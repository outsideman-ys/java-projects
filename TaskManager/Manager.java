import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Manager {
    private HashMap<Integer, Task> tasks = new HashMap<Integer, Task>();
    private HashMap<Integer, Epictask> epics = new HashMap<Integer, Epictask>();
    private int state;
    private static int id = 0;
    private static ArrayList<Integer> idies = new ArrayList<Integer>();
    private String name;
    private String description;

    private void CreateSimpleTask() {
        System.out.println("Input the name of task: ");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Input the description of task: ");
        description = scanner.nextLine();
        Task task = new Task(name, description, id);
        tasks.put(id, task);
        idies.add(id);
        id++;
        System.out.println("Task's creation is complete");
        ShowMenu();
        scanner.close();
    }

    private void CreateEpicTask() {
        System.out.println("Input the name of task: ");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Input the description of task: ");
        description = scanner.nextLine();
        Epictask epic = new Epictask(name, description, id);
        epics.put(id, epic);
        idies.add(id);
        id++;
        System.out.println("Task's creation is complete");
        ShowMenu();
        scanner.close();
    }

    private void CreateSubTask() {
        System.out.println("Input the name of task: ");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Input the description of task: ");
        description = scanner.nextLine();
        System.out.println("Choose epic task by ID: \n");
        if(!epics.isEmpty()) {
            for(Integer key : epics.keySet()) {
                System.out.println("\nName: " + epics.get(key).name);
                System.out.println("Description: " + epics.get(key).description);
                System.out.println("ID: " + epics.get(key).id + "\n");
            }
            int temp;
            temp = scanner.nextInt();
            if(epics.get(temp) == null) {
                System.out.println("Bad input, try again");
                CreateSubTask();
                scanner.close();
            } else {
                Subtask subtask = new Subtask(name, description, id);
                epics.get(temp).subtasks.put(id, subtask);
                idies.add(id);
                id++;
            }
        } else {
            System.out.println("Epics is empty, create epic task first");
            ShowMenu();
            scanner.close();
        }
        
        System.out.println("Task's creation is complete");
        ShowMenu();
        scanner.close();
    }

    private String ConvertStatus(int status) {
        if(status == 0) {
            return "NEW";
        } else if(status == 1) {
            return "IN PROGRESS";
        } else {
            return "DONE";
        }
    }

    private void ShowTasks() {
        System.out.println("The ordinary tasks: ");
        if (!tasks.isEmpty()) {
            for (Integer key : tasks.keySet()) {
                System.out.println("\nName: " + tasks.get(key).name);
                System.out.println("Description: " + tasks.get(key).description);
                System.out.println("Status: " + ConvertStatus(tasks.get(key).status));
                System.out.println("ID: " + tasks.get(key).id + "\n");
            }
        }

        System.out.println("\nThe epic tasks: ");
        if (!epics.isEmpty()) {
            for (Integer key : epics.keySet()) {
                System.out.println("\nName: " + epics.get(key).name);
                System.out.println("Description: " + epics.get(key).description);
                System.out.println("Status: " + ConvertStatus(epics.get(key).status));
                System.out.println("ID: " + epics.get(key).id);
                if (!epics.get(key).subtasks.isEmpty()) {
                    System.out.println("\nSubtasks: ");
                    for (Integer subKey : epics.get(key).subtasks.keySet()) {
                        System.out.println("\n\tName: " + epics.get(key).subtasks.get(subKey).name);
                        System.out.println("\tDescription: " + epics.get(key).subtasks.get(subKey).description);
                        System.out.println("\tStatus: " + ConvertStatus(epics.get(key).subtasks.get(subKey).status));
                        System.out.println("\tID: " + epics.get(key).subtasks.get(subKey).id);
                    }
                }
            }
        }
        System.out.println();
        ShowMenu();
    }

    private void PrintTask(int key, int state) {
        if (state == 0) {
            System.out.println("Found task: \n");
            System.out.println("\nName: " + tasks.get(key).name);
            System.out.println("\nDescription: " + tasks.get(key).description);
            System.out.println("\nStatus: " + ConvertStatus(tasks.get(key).status));
            System.out.println("\nID: " + tasks.get(key).id + "\n");
        } else if (state == 1) {
            System.out.println("Found epic task: \n");
            System.out.println("\nName: " + epics.get(key).name);
            System.out.println("\nDescription: " + epics.get(key).description);
            System.out.println("\nStatus: " + ConvertStatus(epics.get(key).status));
            System.out.println("\nID: " + epics.get(key).id + "\n");
        }
    }

    private void PrintTask(int key, int subkey, int state) {
        if(state == 2) {
            System.out.println("Found sub task: \n");
            System.out.println("\nName: " + epics.get(subkey).subtasks.get(key).name);
            System.out.println("\nDescription: " + epics.get(subkey).subtasks.get(key).description);
            System.out.println("\nStatus: " + ConvertStatus(epics.get(subkey).subtasks.get(key).status));
            System.out.println("\nID: " + epics.get(subkey).subtasks.get(key).id + "\n");
        } else {
            System.out.println("Bad call, try again");
            return;
        }
    }

    private void FindTaskById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the ID from 0 to " + (id-1));
        int temp;
        temp = scanner.nextInt();
        if (temp < 0 || temp >= id) {
            System.out.println("Bad input, try again");
            FindTaskById();
            scanner.close();
        } else {
            if (tasks.get(temp) != null) {
                PrintTask(temp, 0);
            } else if (epics.get(temp) != null) {
                PrintTask(temp, 1);
            } else {
                for (Integer key : epics.keySet()) {
                    if (epics.get(key).subtasks.get(temp) != null) {
                        PrintTask(temp, key, 2);
                    }
                }
            }
        }
        ShowMenu();
        scanner.close();
    }

    private void DeleteTaskById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the ID from by index: " + idies);
        int temp;
        temp = scanner.nextInt();
        if (temp < 0 || temp >= id) {
            System.out.println("Bad input, try again");
            DeleteTaskById();
            scanner.close();
        } else {
            if (tasks.get(temp) != null) {
                tasks.remove(temp);
                idies.remove(temp);
            } else if (epics.get(temp) != null) {
                if (!epics.get(temp).subtasks.isEmpty()) {
                    for (Integer key : epics.get(temp).subtasks.keySet()) {
                        epics.get(temp).subtasks.remove(key);
                        idies.remove(key);
                    }
                    epics.remove(temp);
                    idies.remove(temp);
                } else {
                    epics.remove(temp);
                    idies.remove(temp);
                }
            } else {
                for (Integer key : epics.keySet()) {
                    if (epics.get(key).subtasks.get(temp) != null) {
                        epics.get(key).subtasks.remove(temp);
                        idies.remove(temp);
                    }
                }
            }
        }
        ShowMenu();
        scanner.close();
    }

    private void ShowTaskMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the type of task:\n" +
            " 1 - Ordinary task \n 2 - Epic task \n 3 - Subtask \n 0 - exit \n");
        state = scanner.nextInt();

        switch (state) {
            case 0:
                ShowMenu();
                scanner.close();
                break;
            case 1:
                CreateSimpleTask();
                scanner.close();
                break;
            case 2:
                CreateEpicTask();
                scanner.close();
                break;
            case 3:
                CreateSubTask();
                scanner.close();
                break;
            default:
                System.out.println("Bad input, try again");
                ShowTaskMenu();
                scanner.close();
        }
    }

    private void ChangeTask(Task task, int state) {
        Scanner scanner = new Scanner(System.in);
        if (state == 1) {
            System.out.println("Input name: ");
            name = scanner.nextLine();
            task.ChangeName(name);
        } else if (state == 2) {
            System.out.println("Input description: ");
            description = scanner.nextLine();
            task.ChangeDescription(description);
        } else {
            System.out.println("Input status: ");
            int status = scanner.nextInt();
            if (status < 0 || status > 2) {
                System.out.println("Bad input, try again");
                ChangeTask(task, state);
            }
            Class<?> cls = task.getClass();
            if (cls.getName() == "Task") {
                task.ChangeStatus(status);
            } else if (cls.getName() == "Subtask") {
                task.ChangeStatus(status);
            } else {
                Epictask epic = (Epictask) task;
                task.ChangeStatus(status);
                for (Integer key : epic.subtasks.keySet()) {
                    epic.subtasks.get(key).ChangeStatus(status);
                }
            } 
        }
        System.out.println("Changing is complete!\n");
        ShowMenu();
        scanner.close();
    }

    private void FindTaskById(int id, int state) {
        if (tasks.get(id) != null) {
            ChangeTask(tasks.get(id), state);
        } else if (epics.get(id) != null) {
            ChangeTask(epics.get(id), state);
        } else {
            for (Integer key : epics.keySet()) {
                if (epics.get(key).subtasks.get(id) != null) {
                    ChangeTask(epics.get(key).subtasks.get(id), state);
                }
            }
        }
    }

    private void ShowUpdateMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the ID from 0 to " + (id-1));
        int temp;
        temp = scanner.nextInt();
        if (temp < 0 || temp >= id) {
            System.out.println("Bad input, try again");
            ShowUpdateMenu();
            scanner.close();
        } else {
            System.out.println("Choose what you want to change: \n" +
            " 1 - Name \n 2 - Description \n 3 - Status\n");
            int state;
            state = scanner.nextInt();
            if (state <= 0 || state > 3) {
                System.out.println("Bad input, try again");
                ShowUpdateMenu();
                scanner.close();
            } else {
                FindTaskById(temp, state);
            }
        }
    }

    private void DeleteTasks() {
        if (!tasks.isEmpty()) {
            tasks.clear();
        }
        if (!epics.isEmpty()) {
            for (Integer key: epics.keySet()) {
                if (!epics.get(key).subtasks.isEmpty()) {
                    epics.get(key).subtasks.clear();    
                }
            }
            epics.clear();
        }
        idies.clear();
        ShowMenu();
    }

    public void ShowMenu() {
        System.out.println("Choose what do you want? From 0 to 6\n" +
            " 0 - exit \n 1 - show tasks \n 2 - delete tasks \n 3 - get task by ID \n" +
            " 4 - create task \n 5 - update task \n 6 - delete task by ID \n");
        Scanner scanner = new Scanner(System.in);
        state = scanner.nextInt();

        switch (state) {
            case 0:
                scanner.close();
                return;
            case 1:
                ShowTasks();
                scanner.close();
                break;
            case 2:
                DeleteTasks();
                scanner.close();
                break;
            case 3:
                FindTaskById();
                scanner.close();
                break;
            case 4:
                ShowTaskMenu();
                scanner.close();
                break;
            case 5:
                ShowUpdateMenu();
                scanner.close();
                break;
            case 6:
                DeleteTaskById();
                scanner.close();
                break;
            default:
                System.out.println("Bad input, try again");
                ShowMenu();
                scanner.close();
        } 
    }

}
