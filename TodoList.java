import java.util.InputMismatchException;
import java.util.Scanner;

public class TodoList {
    public static void main(String[] args) {
        Scanner kbm = new Scanner(System.in);
        String[] tasks = new String[0];
        String command = "";

        while (!(command == "e")) {
            System.out.println("=== To-Do List ===");
            System.out.println("Commands List");
            System.out.println("a = Add new tasks");
            System.out.println("v = View all tasks");
            System.out.println("r = Remove a task");
            System.out.println("e = Exit");

            System.out.print("Enter a command: ");
            command = kbm.nextLine();

            try {
                if (command.equals("a")) {
                    tasks = addTask(tasks, kbm);
                } else if (command.equals("v")) {
                    viewTasks(tasks);
                } else if (command.equals("r")) {
                    tasks = removeTask(tasks, kbm);
                } else if (command.equals("e")) {
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                } else {
                    System.out.println("Invalid command. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a number");
            }

        }

        kbm.close();

    }

    public static String[] addTask(String[] tasks, Scanner kbm) {
        System.out.print("Enter the task: ");
        String newTask = kbm.nextLine();

        tasks = arrayAppend(tasks, newTask);
        wait(200);
        System.out.println("Task has been added sucessfully");
        return tasks;

    }

    public static String[] arrayAppend(String[] stringArray, String toAdd) {
        int extraInt = stringArray.length + 1;

        String[] newArray = new String[extraInt];

        for (int i = 0; i < stringArray.length; i++) {
            newArray[i] = stringArray[i];
        }

        newArray[extraInt - 1] = toAdd;

        return newArray;
    }

    public static void viewTasks(String[] tasks) {

        if (tasks.length == 0) {
            System.out.println("There are no tasks to show right now...");
        } else {
            System.out.println("=== All Tasks === \n");
        wait(200);

            for (int i = 0; i < tasks.length; i++) {
                System.out.println((i + 1) + ". " + tasks[i]);
            }
        wait(200);

            System.out.println("\n === List Printed ===");

        }

    }

    public static String[] removeTask(String[] tasks, Scanner kbm) {

        System.out.println("Loading all tasks");

        viewTasks(tasks);

        System.out.println("Enter the number for the task you want to remove");
        String newTask = kbm.nextLine();
        int taskNum = Integer.parseInt(newTask);

        tasks = removeEntry(tasks, taskNum);

        return tasks;

    }

    public static String[] removeEntry(String[] xs, int index) {

        try {
            xs[index - 1] = null;
            wait(500);
            System.out.println("The task has been removed");
            return xs;

        } catch (NullPointerException e) {
            System.out.println("That task isn't in the list");
        wait(200);
            System.out.println("Returning to main menu");
            return xs;

        }

    }

    public static void wait(int waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (Exception e) {
            // do something with e
        }
    }
}
