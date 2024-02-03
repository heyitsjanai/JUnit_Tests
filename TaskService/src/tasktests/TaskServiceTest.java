//					  SNHU CS-320 Module Four Milestone 				    //
//         Author: 				Janai Cano                                  //
//         Date: 				05-26-2023                                  //

package tasktests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import tasks.TaskService;
import tasks.Task;

public class TaskServiceTest {
	private TaskService taskService;
	private Task task1;
	private Task task2;
	
	@BeforeEach
	public void setUp() {
		taskService = new TaskService();
        task1 = new Task("Task 1", "Task1Name", "Task 1 Description");
        task2 = new Task("Task 2", "Task2Name", "Task 2 Description");
	}
	
	@Test
	public void testAddTask() {
		//adding task 1
		taskService.addTask(task1);
		Map<String, Task> tasks = taskService.getTasks();
		//testing that task 1 was added properly
		assertEquals(1, tasks.size());
		assertTrue(tasks.containsKey("Task 1"));
		assertEquals(task1, tasks.get("Task 1"));
	}

	@Test
    public void testAddTask_DuplicateId() {
        taskService.addTask(task2);
        // Add contact with the same ID should fail
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task2));
        Map<String, Task> tasks = taskService.getTasks();
        //testing that task 2 was only added once
        assertEquals(1, tasks.size());
    }
	
    @Test
    public void testDeleteTask() {
    	//first add task 1 and task 2
        taskService.addTask(task1);
        taskService.addTask(task2);
        //delete task 1
        taskService.deleteTask("Task 1");
        Map<String, Task> tasks = taskService.getTasks();
        //testing that task 1 was deleted properly
        assertEquals(1, tasks.size());
        assertFalse(tasks.containsKey("Task 1"));
        //testing that task 2 was not deleted
        assertTrue(tasks.containsKey("Task 2"));
        assertEquals(task2, tasks.get("Task 2"));
    }
    
    @Test
    public void testUpdateTask() {
    	//add task1
    	taskService.addTask(task1);
        //update task1
        taskService.updateTask("Task 1", "name", "First Task");
        Map<String, Task> tasks = taskService.getTasks();
        //testing that task 1 was updated properly
        assertEquals(1, tasks.size());
        assertTrue(tasks.containsKey("Task 1"));
        //testing that task1 name is updated properly
        assertEquals(task1, tasks.get("Task 1"));
    }
    
    @Test
    public void testUpdateDescription() {
    	//add task2
    	taskService.addTask(task2);
        //update task2
        taskService.updateTask("Task 2", "description", "This is the second task");
        Map<String, Task> tasks = taskService.getTasks();
        //testing that task 2 was updated properly
        assertEquals(1, tasks.size());
        assertTrue(tasks.containsKey("Task 2"));
        //testing that task2 description is updated properly
        assertEquals(task2, tasks.get("Task 2"));
    }
    
    @Test
    public void testNonValidUpdate() {
    	//add task1
    	taskService.addTask(task1);
        Map<String, Task> tasks = taskService.getTasks();
        //testing that task 1 was added properly
        assertEquals(1, tasks.size());
        assertTrue(tasks.containsKey("Task 1"));
        //testing that exception is thrown for non-existent 'priority' field
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTask("Task 1", "priority", "low"));
        
    }
}
