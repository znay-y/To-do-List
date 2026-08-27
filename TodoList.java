
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
            showOptions(taskManager);
            choice = IO.INTput(sc, "Please enter your choice: ");
            while (!choiceValid(choice)) {
                IO.print("Invalid choice. Please try again.");
                choice = IO.INTput(sc, "Please enter your choice: ");
            }
            if (choice == 1) {
                addTask(taskManager, sc);
            } else if (choice == 2) {
                if (taskManager.size() == 0) {
                    IO.clear();
                    IO.print("You can't view you tasks are there aren't any tasks to view");
                    IO.enterPause(sc);
                } else {
                    viewTasks(taskManager, sc);
                }
            } else if (choice == 3) {
                if (taskManager.size() == 0) {
                    IO.clear();
                    IO.print("Tasks cannot be marked as complete as there are no tasks");
                    IO.enterPause(sc);
                } else {
                    markTaskComplete(taskManager, sc);
                }
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

    public static boolean choiceValid(int choice) {
        return choice >= 1 && choice <= 4;
    }

    public static void showOptions(ArrayList<task> taskManager) {
        IO.clear();
        IO.print("Welcome to your Todo List!");
        IO.print("1. Add a task");
        if (taskManager.size() == 0) {
            IO.print("2. Locked");
            IO.print("3. Stop looking at the locked options AND JUST DO NUMBER 1 OR 4");
        } else if (taskManager.size() == 1) {
            IO.print("2. View the only task you have");
            IO.print("3. Mark the only task you have as complete");
        } else {
            IO.print("2. View tasks");
            IO.print("3. Mark a task as complete");
        }
        IO.print("4. Exit");
    }

    public static void addTask(ArrayList<task> taskManager, Scanner sc) {
        IO.clear();
        String name = IO.StringPut(sc, "Enter the name of your task");
        String desc = IO.StringPut(sc, "Enter the description or leave blank");
        if (desc.isEmpty()) {
            taskManager.add(createTask(name));
        } else {
            taskManager.add(createTask(name, desc));

        }
        IO.print("Task added");
        IO.enterPause(sc);
    }

    public static task createTask(String name, String description) {
        return new task(name, description);
    }

    public static task createTask(String name) {
        return new task(name);
    }

    public static void viewTasks(ArrayList<task> taskManager, Scanner sc) {
        int count = 0;
        for (task t : taskManager) {
            count++;
            IO.print(("Task number: " + count));
            IO.print("Name: " + getName(t));
            try {
                if (getDescription(t).equals(null)) {
                    IO.print("There is no description");
                } else {
                    IO.print("Description: " + getDescription(t));
                }
            } catch (NullPointerException e) {
                IO.print("There is no description");
            }
            if (getComplete(t)) {
                IO.print("Complete: Yes\n");
            } else {
                IO.print("Complete: No\n");
            }
        }
        IO.enterPause(sc);
    }

    public static void markTaskComplete(ArrayList<task> taskManager, Scanner sc) {
        IO.print("Which task would you like to mark as complete?");
        int count = 0;
        for (task t : taskManager) {
            if (getComplete(t) == false) {
                count++;
                IO.print((count) + ". " + getName(t));
            } else {
                continue;
            }
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