package com.mycompany.mabaso_vusani_part_2;
import javax.swing.JOptionPane;
import java.util.Scanner;


public class Task {

    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;
       

    public Task(String taskName, int taskNumber, String taskDescription,
                String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = generateTaskID();
        this.taskStatus = taskStatus;
    }

    public Task() {
    }

    public boolean checkTaskDescription() {
        return this.taskDescription.length() <= 50;
    }

    public String printTaskDetails() {
        String details = "Task Status: " + taskStatus + "\n" +
                "Developer Details: " + developerDetails + "\n" +
                "Task Number: " + taskNumber + "\n" +
                "Task Name: " + taskName + "\n" +
                "Task Description: " + taskDescription + "\n" +
                "Task ID: " + taskID + "\n" +
                "Task Duration: " + taskDuration + " hours";
        return details;
    }

    public String generateTaskID() {
        return this.taskName.substring(0, 2).toUpperCase() + ":" +
                this.taskNumber + ":" +
                this.developerDetails.substring(developerDetails.length() - 3).toUpperCase();
    }

    public String getTaskStatus() {
        String status = null;
        System.out.println("1. To Do");
        System.out.println("2. Done");
        System.out.println("3. Doing");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                status = "To Do";
                break;

            case 2:
                status = "Done";
                break;

            case 3:
                status = "Doing";
                break;

            default:
                System.out.println("Invalid selection");
                break;
        }
        return status;
    }

    public static String [] addTasks(String[] developers, String[] taskNames, int[] taskIDs, int[] taskDurations, String[] taskStatuses) {
        int totalHours = 0;
        for (int i = 0; i < taskNames.length; i++) {
            String taskName = JOptionPane.showInputDialog("Enter the task name "+i+" :");
            String taskDescription = JOptionPane.showInputDialog("Enter the task description:");
            String developerDetails = JOptionPane.showInputDialog("Enter the developer details");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter the task duration in hours:"));
            String taskStatus = JOptionPane.showInputDialog("Enter the task status (To Do, Done, Doing)");

            Task task = new Task(taskName, i, taskDescription, developerDetails, taskDuration, taskStatus);
            developers[i] = developerDetails;
            taskNames[i] = taskName;
            taskIDs[i] = i;
            taskDurations[i] = taskDuration;
            taskStatuses[i] = taskStatus;

            totalHours += taskDuration;
        }
        
        JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);
        return developers;
    }

    public static String [] getDevelopers(String[] developers) {
        return developers;
    }
    public static void displayReport(String[] developers, String[] taskNames, int[] taskIDs, int[] taskDurations, String[] taskStatuses) {
        System.out.println("Full Report:");
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i] != null) {
                Task task = new Task(taskNames[i], taskIDs[i], "", developers[i], taskDurations[i], taskStatuses[i]);
                System.out.println(task.printTaskDetails());
                System.out.println();
            }
        }
    }

    public static String displayTasksWithStatus(String[] developers, String[] taskNames, int[] taskIDs, int[] taskDurations, String[] taskStatuses, String status) {
        System.out.println("Tasks with status: " + status);
        String output = null;
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i] != null && taskStatuses[i].equals(status)) {
                Task task = new Task(taskNames[i], taskIDs[i], "", developers[i], taskDurations[i], taskStatuses[i]);
                System.out.println("Task Name: " + task.taskName);
                System.out.println("Developer: " + task.developerDetails);
                System.out.println("Task Duration: " + task.taskDuration + " hours");
                System.out.println();
                output = task.developerDetails + ","+ task.taskName;                
                
            }
        }
        return output;
    }

    public String displayTaskWithLongestDuration(String[] developers, String[] taskNames, int[] taskIDs, int[] taskDurations, String[] taskStatuses) {
        Task longestDurationTask = null;
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i] != null) {
                Task task = new Task(taskNames[i], taskIDs[i], "", developers[i], taskDurations[i], taskStatuses[i]);
                if (longestDurationTask == null || task.taskDuration > longestDurationTask.taskDuration) {
                    longestDurationTask = task;
                }
            }
        }

        if (longestDurationTask != null) {
            System.out.println("Task with longest duration:");
            System.out.println("Task Name: " + longestDurationTask.taskName);
            System.out.println("Developer: " + longestDurationTask.developerDetails);
            System.out.println("Task Duration: " + longestDurationTask.taskDuration + " hours");
            System.out.println();
        }
        return longestDurationTask.developerDetails + ", " +longestDurationTask.taskDuration; 
    }
    
    public String [] displayDeveloperName(String [] developers){
        return developers;
    }

    public String searchTaskByName(String[] developers, String[] taskNames, int[] taskIDs, int[] taskDurations, String[] taskStatuses, String searchTaskName) {
        System.out.println("Search Results for Task Name: " + searchTaskName);
        String output = null;
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i] != null && taskNames[i].equals(searchTaskName)) {
                Task task = new Task(taskNames[i], taskIDs[i], "", developers[i], taskDurations[i], taskStatuses[i]);
                System.out.println(task.printTaskDetails());
                System.out.println();
                output = task.developerDetails + ","+ task.taskName;                
            }
        }
        return output;
    }

    public static String searchTasksByDeveloper(String[] developers, String[] taskNames, int[] taskIDs, int[] taskDurations, String[] taskStatuses, String searchDeveloper) {
        System.out.println("Search Results for Developer: " + searchDeveloper);
        String developerTaskName ="";
        for (int i = 0; i < developers.length; i++) {
            if (developers[i] != null && developers[i].equals(searchDeveloper)) {
                Task task = new Task(taskNames[i], taskIDs[i], "", developers[i], taskDurations[i], taskStatuses[i]);
                System.out.println("Task Name: " + task.taskName);
                System.out.println("Task Status: " + task.taskStatus);
                System.out.println();
                developerTaskName = task.taskName;

            }
        }
        return developerTaskName;
    }

    public String[] deleteTaskByName(String[] taskNames, String deleteTaskName) {
        int count = 0;
        for(String task:taskNames){
            if(task.equals(deleteTaskName)){
                count++;
            }
        }
        
        if(count==0){
            return taskNames;
        }
        
        String [] newTasks = new String[taskNames.length - count];
        int newIndex =0;
        for(String newTaskName : taskNames ){
            if(!newTaskName.equals(deleteTaskName)){
                newTasks[newIndex] = newTaskName;
                newIndex++;
            }
        }
        return newTasks;
    }
}
