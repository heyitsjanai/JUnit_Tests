
//					  SNHU CS-320 Module Four Milestone 				    //
//         Author: 				Janai Cano                                  //
//         Date: 				05-26-2023                                  //

package tasks;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	//declaring local variable - HashMap to store tasks
    protected Map<String, Task> tasks;
    
    public TaskService() {
        this.tasks = new HashMap<>();
    }
    
    //function to add a new task
    public void addTask(Task task) {
    	//make sure the task is not null
    	if (task != null) {
    		//get the id from the task object
            String taskId = task.getTaskId();
            //make sure the id is not already in use
            if (!tasks.containsKey(taskId)) {
            	//if not, task is added to the HashMap
                tasks.put(taskId, task);
                System.out.println("Task added successfully.");
            } 
            //if task id already exists, throw exception
            else {
                throw new IllegalArgumentException("Task with ID " + taskId + " already exists.");
            }
        } 
    	//if null, throw exception
        else {
            throw new IllegalArgumentException("Task ID cannot be null.");
        }
    }
    
    //function to delete a task
    public void deleteTask(String taskId) {
    	//checks if the task exists in HashMap
        if (taskId != null && tasks.containsKey(taskId)) {
        	//if so, task is removed from the HashMap
            tasks.remove(taskId);
            System.out.println("Task with ID " + taskId + " deleted successfully.");
        } 
        //if task does not exist, throw exception
        else {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist.");
        }
    }
    
    //function to update a task field -- user must specify what field to be updated (name or description only)
    public void updateTask(String taskId, String field, String value) {
    	//checks if the task exists in HashMap
        if (taskId != null && tasks.containsKey(taskId)) {
        	//if it exists in HashMap, task object is retrieved
            Task task = tasks.get(taskId);
            //checks for the user-specified field to be updated
            switch (field) {
                case "name":
                	//updates task's name with the specified value
                    task.setTaskName(value);
                    break;
                case "description":
                	//updates task description with the specified value
                    task.setTaskDescription(value);
                    break;
                default:
                	//default case is to throw exception since any other field does not exist
                	throw new IllegalArgumentException("Task field " + field + " does not exist.");
            }
            //once updated, user is notified
            System.out.println("Task field " + field + " updated successfully.");
        } 
        //if task does not exist, throw exception
        else {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist.");
        }
    }
    
    //returns the HashMap of contacts
	public Map<String, Task> getTasks() {
		return tasks;
	}
    
}