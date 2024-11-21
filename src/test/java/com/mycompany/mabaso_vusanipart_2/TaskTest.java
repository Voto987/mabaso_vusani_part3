/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mabaso_vusanipart_2;

import com.mycompany.mabaso_vusani_part_2.Task;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {
    
//    FINAL POE UNIT TESTS
    public TaskTest() {
    }
    @Test
    public void getDevelopersTest() {
       
        String [] expectedDeveloper = {"Mike Smith", "Edward Harrison", 
            "Samantha Paulson", "Gelnda Oberholzer"};        
        Task task  = new Task();
        String actualDeveloper [] = Task.getDevelopers(expectedDeveloper);
        
        assertEquals(expectedDeveloper, actualDeveloper, 
                "Incorrect developers provided"); 
    }
    //FINAL POE TEST
    @Test
    public void testLongestDuration(){
        String [] expectedDeveloper = {"Mike Smith", "Edward Harrison", 
            "Samantha Paulson", "Glenda Oberholzer"};
        String taskName[] = {"Create Login", "Create Login", "Create Report", "Add Task"};
        int [] taskID = {1,2,3,4};
        int[] taskDuration = {5,8,2,11};
        String taskStatus [] = {"To Do", "Doing","Done","To Do"};
        Task task  = new Task();        
        String longestDuration = task.displayTaskWithLongestDuration(
                expectedDeveloper,taskName, taskID, 
                taskDuration, taskStatus);
        String expectedOutput = "Glenda Oberholzer, 11";
        assertEquals(longestDuration, expectedOutput, 
                "Incorrect developers provided");     
    }
    //FINAL POE TEST
    @Test
    public void testSearchForTasks() {
      String [] expectedDeveloper = {"Mike Smith", "Edward Harrison", 
          "Samantha Paulson", "Glenda Oberholzer"};
      String taskName[] = {"Create Login", "Create Add Features", 
          "Create Report", "Add Task"};
      int [] taskID = {1,2,3,4};
      int[] taskDuration = {5,8,2,11};
      String taskStatus [] = {"To Do", "Doing","Done","To Do"};
      Task task  = new Task();  
      String expectedOutput = "Mike Smith,Create Login";
      String output = task.searchTaskByName(expectedDeveloper,
              taskName, taskID, taskDuration, 
              taskStatus,"Create Login");
      assertEquals(expectedOutput, output);
       
    }
    //FINAL POE TEST
    @Test
    public void testDeleteTaskByName() {
        String taskName[] = {"Create Login", "Create Add Features", "Create Report",
            "Add Task"};
        Task task = new Task();
        String[] actualOutput = task.deleteTaskByName(taskName, 
                "Create Report");
        String []expectedOutput = {"Create Login", "Create Add Features", "Add Task"};
        assertArrayEquals(expectedOutput, actualOutput);
        
    }
    //FINAL POE TEST
    @Test
    public void testSearchAllTasksAssignedToDeveloper(){
      String [] expectedDeveloper = {"Mike Smith", "Edward Harrison", 
          "Samantha Paulson", "Glenda Oberholzer"};
      String taskName[] = {"Create Login", "Create Add Features", 
          "Create Reports", "Add Task"};
      int [] taskID = {1,2,3,4};
      int[] taskDuration = {5,8,2,11};
      String taskStatus [] = {"To Do", "Doing","Done","To Do"};       
        Task task = new Task();
        String actualOutput = task.searchTasksByDeveloper(expectedDeveloper,
              taskName, taskID, taskDuration, 
              taskStatus, "Samantha Paulson");
        String expectedOutput ="Create Reports";
        assertEquals(expectedOutput,actualOutput);
    }
}


