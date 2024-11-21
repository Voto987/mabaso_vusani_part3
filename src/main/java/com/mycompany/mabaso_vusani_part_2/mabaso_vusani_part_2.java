/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mabaso_vusani_part_2;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class mabaso_vusani_part_2 {


    public static void main(String[] args) {

        System.out.println("Please register an account \n");
        Register register = new Register();

        System.out.println("Register :: Please enter your username \n");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        if (register.checkUserName(username)) {
            System.out.println("Username successfully captured");
        } else {
            System.out.println("Username is not correctly formatted, please "
                    + "ensure that your username contains an underscore and is no"
                    + " more than 5 characters in length.");
        }
        register.setUsername(username);

        System.out.println("Please login to your account");

        System.out.println("Register :: Please enter password");
        String password = scanner.nextLine();
        register.setPassword(password);

        if (register.checkPasswordComplexity(password)) {
            System.out.println("Password successfully captured");
        } else {
            System.out.println("Password is not correctly formatted, please"
                    + " ensure that the password contains at least 8 characters,"
                    + " a capital letter, a number and a special character.");
        }

        System.out.println("Register :: Please enter First Name");
        String firstName = scanner.nextLine();
        register.setFirstName(firstName);

        System.out.println("Register :: Please enter Last Name");
        String lastName = scanner.nextLine();
        register.setLastName(lastName);

        System.out.println("Login :: Please enter username");
        Login login = new Login();
        username = scanner.nextLine();
        login.setUsername(username);

        System.out.println("Login :: Please enter password");
        password = scanner.nextLine();
        login.setPassword(password);

        if (login.loginUser(register.getUsername(), login.getUsername(),
                register.getPassword(), login.getPassword())) {
            System.out.println("Welcome " + register.getFirstName() + ", "
                    + register.getLastName() + " it is great to see you again.");

            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
            int numTasks = Integer.parseInt(JOptionPane.showInputDialog(
                    "How many tasks do you want to enter?"));

            String[] developers = new String[numTasks];
            String[] taskNames = new String[numTasks];
            int[] taskIDs = new int[numTasks];
            int[] taskDurations = new int[numTasks];
            String[] taskStatuses = new String[numTasks];

            Task.addTasks(developers, taskNames, taskIDs, taskDurations, taskStatuses);

            Task task = new Task();

            int option = 0;
            while (option != 8) {
                option = Integer.parseInt(JOptionPane.showInputDialog(
                        "Choose an option:\n" +
                                "1. Add tasks\n" +
                                "2. Show report\n" +
                                "3. Display tasks with status 'Done'\n" +
                                "4. Display task with the longest duration\n" +
                                "5. Search for a task by name\n" +
                                "6. Search for tasks assigned to a developer\n" +
                                "7. Delete task by name\n" +
                                "8. Quit"
                ));

                switch (option) {
                    case 1:
                        Task.addTasks(developers, taskNames, taskIDs, taskDurations, taskStatuses);
                        break;
                    case 2:
                        Task.displayReport(developers, taskNames, taskIDs, taskDurations, taskStatuses);
                        break;
                    case 3:
                        Task.displayTasksWithStatus(developers, taskNames, taskIDs, taskDurations, taskStatuses, "Done");
                        break;
                    case 4:
                        task.displayTaskWithLongestDuration(developers, taskNames, taskIDs, taskDurations, taskStatuses);
                        break;
                    case 5:
                        String searchTaskName = JOptionPane.showInputDialog("Enter task name to search:");
                        task.searchTaskByName(developers, taskNames, taskIDs, taskDurations, taskStatuses, searchTaskName);
                        break;
                    case 6:
                        String searchDeveloper = JOptionPane.showInputDialog("Enter developer name to search tasks:");
                        Task.searchTasksByDeveloper(developers, taskNames, taskIDs, taskDurations, taskStatuses, searchDeveloper);
                        break;
                    case 7:
                        String deleteTaskName = JOptionPane.showInputDialog("Enter the task name to delete:");
                        taskNames = task.deleteTaskByName(taskNames, deleteTaskName);
                        break;
                    case 8:
                        JOptionPane.showMessageDialog(null, "Goodbye! Thanks for using Easykanban");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option!");
                }
            }

        } else {
            System.out.print("Username or password incorrect, please try again");
        }
    }
}
