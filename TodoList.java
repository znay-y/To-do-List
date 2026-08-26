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
        mainMenu(taskManager,sc);
    }
}