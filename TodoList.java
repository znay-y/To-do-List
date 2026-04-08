import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class TodoList {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner kbm = new Scanner(System.in);

        // Pre-populate the task list with 20 tasks
        // Purley for testing purposes
        arrayAppend(tasks, "Call the dentist");
        arrayAppend(tasks, "Walk the dog");
        arrayAppend(tasks, "Read 10 pages of a book");
        arrayAppend(tasks, "Buy groceries");
        arrayAppend(tasks, "Clean the kitchen");
        arrayAppend(tasks, "Reply to emails");
        arrayAppend(tasks, "Go for a 20-minute run");
        arrayAppend(tasks, "Schedule a meeting");
        arrayAppend(tasks, "Do the laundry");
        arrayAppend(tasks, "Water the plants");
        arrayAppend(tasks, "Pay utility bills");
        arrayAppend(tasks, "Organize desk");
        arrayAppend(tasks, "Prepare dinner");
        arrayAppend(tasks, "Check calendar for tomorrow");
        arrayAppend(tasks, "Back up important files");
        arrayAppend(tasks, "Review monthly budget");
        arrayAppend(tasks, "Stretch for 10 minutes");
        arrayAppend(tasks, "Update task list");
        arrayAppend(tasks, "Take out the trash");
        arrayAppend(tasks, "Refill water bottle");
        String command = "";

        while (!(command.equalsIgnoreCase("e"))) {
            clearWithLinuxCommand();

            System.out.println("=== To-Do List ===");
            wait(300);

            System.out.println("\nCommands List");
            wait(100);

            System.out.println("a = Add new tasks");
            wait(100);

            System.out.println("v = View all tasks");
            wait(100);

            System.out.println("r = Remove a task");
            wait(100);

            System.out.println("e = Exit");
            wait(300);

            System.out.print("Enter a command: ");
            command = kbm.nextLine();

            try {
                if (command.equals("a")) {
                    addTask(tasks, kbm);
                } else if (command.equalsIgnoreCase("v")) {
                    viewTasks(tasks, kbm, false);
                } else if (command.equalsIgnoreCase("r")) {
                    removeTask(tasks, kbm);
                } else if (command.equalsIgnoreCase("e")) {
                    clearWithLinuxCommand();
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                } else {
                    wait(500);
                    clearWithLinuxCommand();
                    wait(500);

                    System.out.println("DON'T");
                    wait(500);
                    System.out.println("TRY");
                    wait(500);
                    System.out.println("THAT");
                    wait(500);
                    System.out.println("AGAIN");
                    System.out.println("\nIs that understood? (yes/no)");
                    String response = kbm.nextLine();
                    while (!response.equalsIgnoreCase("yes")) {
                        System.out.println("WRONG ANSWER");
                        response = kbm.nextLine();
                    }
                    if (response.equalsIgnoreCase("yes")) {
                        clearWithLinuxCommand();
                    } else {

                    }

                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a number");
            }

        }
        clearWithLinuxCommand();
        kbm.close();

    }

    public static void clearWithLinuxCommand() {
        try {
            new ProcessBuilder("clear")
                    .inheritIO()
                    .start()
                    .waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void addTask(ArrayList<String> tasks, Scanner kbm) {
        clearWithLinuxCommand();

        System.out.print("Enter the task: ");
        String newTask = kbm.nextLine();

        arrayAppend(tasks, newTask);
        wait(500);
        System.out.println("Task has been added sucessfully");
        wait(500);
        System.out.println("\nPress enter to return to the main menu");
        kbm.nextLine();

        clearWithLinuxCommand();

    }

    public static void arrayAppend(ArrayList<String> stringArray, String toAdd) {
        stringArray.add(toAdd);
    }

    public static void arrayRemove(ArrayList<String> stringArray, int index, Scanner kbm) {
        stringArray.remove(index - 1);

        wait(500);
        System.out.println("The task has been removed");

        wait(200);
        System.out.println("Press enter to return to the main menu");
        kbm.nextLine();
        clearWithLinuxCommand();

    }

    public static void viewTasks(ArrayList<String> tasks, Scanner kbm, boolean IsRemoval) {
        clearWithLinuxCommand();

        System.out.println("Loading all tasks");

        if (tasks.size() == 0) {
            System.out.println("There are no tasks to show right now...");
        } else {
            System.out.println("\n=== All Tasks === \n");
            wait(500);

            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
                wait(200);
            }
            wait(500);

            if (IsRemoval) {

            } else {
                System.out.println("\n === List Printed ===\n");
                wait(200);

                System.out.println("Press enter to return to the main menu");
                kbm.nextLine();

            }
        }

    }

    public static void removeTask(ArrayList<String> tasks, Scanner kbm) {
        int newOrder = 1;
        viewTasks(tasks, kbm, true);

        System.out.print("\nEnter the number for the task you want to remove: ");
        String newTask = kbm.nextLine();
        int taskNum = Integer.parseInt(newTask);
        clearWithLinuxCommand();
        System.out.println("\n This is what your list will look like:\n");
        for (int i = 0; i < tasks.size(); i++) {
            if (i == taskNum - 1) {
                continue;
            } else {
                System.out.println(newOrder + ". " + tasks.get(i));
                wait(200);
                newOrder++;

            }
        }

        System.out.println("\nIs this the change you want to make? (y/n)");
        String saveornah = kbm.nextLine();

        if (saveornah.equals("y")) {
            arrayRemove(tasks, taskNum, kbm);
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
