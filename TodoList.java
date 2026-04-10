import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class TodoList {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        ArrayList<String> removedTasks = new ArrayList<>();

        Scanner kbm = new Scanner(System.in);

        // Pre-populate the task list with 20 tasks
        // Purely for testing purposes
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

        arrayAppend(removedTasks, "Be cool");
        arrayAppend(removedTasks, "Be Cooler");
        arrayAppend(removedTasks, "Be Warm");
        arrayAppend(removedTasks, "Be Warmer");

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

            System.out.println("d = Delete a task");
            wait(100);

            System.out.println("r = Resore a deleted task");
            wait(100);

            System.out.println("e = Exit");
            wait(300);

            System.out.print("Enter a command: ");
            command = kbm.nextLine();

            try {
                if (command.equalsIgnoreCase("a")) {
                    addTask(tasks, kbm);
                } else if (command.equalsIgnoreCase("v")) {
                    viewTasks(tasks, kbm, false);
                } else if (command.equalsIgnoreCase("d")) {
                    removeTask(tasks, removedTasks, kbm);
                } else if (command.equalsIgnoreCase("r")) {
                    restoreTask(tasks, removedTasks, kbm);
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

    // Clears terminal during excecution (only works on linux)
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

        if (!(checkDupes(tasks, newTask))) {
            wait(500);
            System.out.println("The task is already in the list");
        } else {
            arrayAppend(tasks, newTask);
            wait(500);
            System.out.println("Task has been added sucessfully");
            wait(500);

        }

        System.out.println("\nPress enter to return to the main menu");
        kbm.nextLine();

        clearWithLinuxCommand();

    }

    public static boolean checkDupes(ArrayList<String> tasks, String input) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).equals(input)) {
                return false;
            }
        }
        return true;
    }

    public static void arrayAppend(ArrayList<String> stringArray, String toAdd) {
        stringArray.add(toAdd);
    }

    public static void arrayCopy(ArrayList<String> from, ArrayList<String> to, int index) {
        String tranferValue = from.get(index - 1);
        to.add(tranferValue);
    }

    public static void arrayRemove(ArrayList<String> stringArray, int index, Scanner kbm,boolean move) {
        stringArray.remove(index - 1);

        if(move){
        wait(500);
        System.out.println("The task has been moved");
        }
        else{
                  wait(500);
        System.out.println("The task has been removed");
  
        }

        wait(100);
        System.out.println("Press enter to return to the main menu");
        kbm.nextLine();
        clearWithLinuxCommand();

    }

    public static void viewTasks(ArrayList<String> tasks, Scanner kbm, boolean JustShow) {
        clearWithLinuxCommand();

        System.out.println("Loading all tasks");

        if (tasks.size() == 0) {
            System.out.println("There are no tasks to show right now...");
            System.out.println("\nPress enter to return to the main menu");
            kbm.nextLine();
        } else {
            if (!JustShow) {
                System.out.println("\n=== All Tasks === \n");
                wait(500);

            } else {

            }
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
                wait(100);
            }
            wait(500);

            if (!JustShow) {
                System.out.println("\n === List Printed ===\n");
                wait(100);
                System.out.println("Press enter to return to the main menu");
                kbm.nextLine();
            } else {

            }

        }

    }

    public static void removeTask(ArrayList<String> tasks, ArrayList<String> removed, Scanner kbm) {
        viewTasks(tasks, kbm, true);
        // if empty make it go back
        if (tasks.size() == 0) {

        } else {
            System.out.print("\nEnter the number for the task you want to remove: ");
            String newTask = kbm.nextLine();
            int taskNum = Integer.parseInt(newTask);
            clearWithLinuxCommand();

            boolean isRemoved = showNewList(tasks, taskNum, kbm);

            if (isRemoved) {
                arrayCopy(tasks, removed, taskNum);
                arrayRemove(tasks, taskNum, kbm,false);
            }

        }

    }

    public static boolean showNewList(ArrayList<String> tasks, int task, Scanner kbm) {
        int newOrder = 1;

        System.out.println("\n This is what your list will look like:\n");
        for (int i = 0; i < tasks.size(); i++) {
            if (i == task - 1) {
                continue;
            } else {
                System.out.println(newOrder + ". " + tasks.get(i));
                wait(100);
                newOrder++;

            }
        }

        System.out.println("\nIs this the change you want to make? (y/n)");
        String saveornah = kbm.nextLine();

        if (saveornah.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    public static void restoreTask(ArrayList<String> tasks, ArrayList<String> removedItems, Scanner kbm) {
        viewTasks(removedItems, kbm, true);
        System.out.println("\nThese are your removed tasks.");

        System.out.print("\nEnter the number for the task you want to restore: ");
        String newTask = kbm.nextLine();
        int taskNum = Integer.parseInt(newTask);

        arrayCopy(removedItems, tasks, taskNum);
        arrayRemove(removedItems, taskNum, kbm,true);

    }

    public static void wait(int waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (Exception e) {
            // do something with e
        }
    }
}
