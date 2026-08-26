/*
Ideas
1. Due dates 
2. Priority levels
3. Categories or tags
4. Recurring tasks
5. Seeing cleared tasks
6. Storing tasks externally
7. GUI
*/
import java.util.Scanner;
import java.util.ArrayList;

public class TodoList {
    public static void main(String[] args) {
        ArrayList<task> taskManager = new ArrayList<task>();
        Scanner sc = new Scanner(System.in);
        mainMenu(taskManager, sc);
    }

    public static void mainMenu(ArrayList<task> taskManager, Scanner sc) {
        int choice = 0;
        while (choice != 4) {
            showOptions();
            choice = IO.INTput(sc, "Please enter your choice: ");
            if (choice == 1) {
                addTask(taskManager, sc);
            } else if (choice == 2) {
                viewTasks(taskManager, sc);
            } else if (choice == 3) {
                markTaskComplete(taskManager, sc);
            } else if (choice == 4) {
                IO.clear();
                IO.print("Exiting...");
                IO.enterPause(sc);
            } else {
                IO.print("Invalid choice. Please try again.");
                IO.enterPause(sc);
                mainMenu(taskManager, sc);
            }
        }
    }

    public static void showOptions() {
        IO.clear();
        IO.print("Welcome to your Todo List!");
        IO.print("1. Add a task");
        IO.print("2. View tasks");
        IO.print("3. Mark a task as complete");
        IO.print("4. Exit");
    }

    public static void addTask(ArrayList<task> taskManager, Scanner sc) {
        String name = IO.StringPut(sc, "Gimmie the name");
        String desc = IO.StringPut(sc, "Now gimmie discrip");
        taskManager.add(createTask(name, desc));
    }

    public static task createTask(String name, String description) {
        return new task(name, description);
    }

    public static void viewTasks(ArrayList<task> taskManager, Scanner sc) {
        for (task t : taskManager) {
            IO.print("Name: " + getName(t));
            IO.print("Description: " + getDescription(t));
            if (getComplete(t)) {
                IO.print("Complete: Yes");
            } else {
                IO.print("Complete: No");
            }
        }
        IO.enterPause(sc);
    }

    public static void markTaskComplete(ArrayList<task> taskManager, Scanner sc) {
        IO.print("Which task would you like to mark as complete?");
        for (int i = 0; i < taskManager.size(); i++) {
            IO.print((i + 1) + ". " + getName(taskManager.get(i)));
        }
        int choice = IO.INTput(sc, "Please enter the number of the task: ");
        if (choice < 1 || choice > taskManager.size()) {
            IO.print("Invalid choice. Please try again.");
            markTaskComplete(taskManager, sc);
        } else {
            setComplete(taskManager.get(choice - 1), true);
            IO.print("Task marked as complete.");
            IO.enterPause(sc);
        }
    }

    public static boolean getComplete(task t) {
        return t.complete;
    }

    public static void setComplete(task t, boolean complete) {
        t.complete = complete;
    }

    public static String getName(task t) {
        return t.name;
    }

    public static void setName(task t, String name) {
        t.name = name;
    }

    public static String getDescription(task t) {
        return t.description;
    }

    public static void setDescription(task t, String description) {
        t.description = description;
    }
    
}