package tasks;
//					  SNHU CS-320 Module Four Milestone 				    //
//         Author: 				Janai Cano                                  //
//         Date: 				05-26-2023                                  //


public class Task {
	//declaring local variables
	private final String taskId;
	private String taskName;
	private String taskDescription;
	
	public Task(String taskId, String taskName, String taskDescription) {
		//setting id -- ID cannot be changed once set and added to HashMap
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
        }
		else {
			this.taskId = taskId;
		}
		//setting all other variables
		setTaskName(taskName);
		setTaskDescription(taskDescription);
	}
	//Getters
	public String getTaskId() {
        return taskId;
    }
	
	public String getTaskName() {
        return taskName;
    }

	public String getDescription() {
        return taskDescription;
    }
	
	//Setters
	public void setTaskName(String taskName) {
		//input validation - taskName must be between 1 and 10 characters
		if (taskName != null && taskName.length() <= 10) {
			this.taskName = taskName;
		}
		else {
			throw new IllegalArgumentException("Invalid name");
		}
	}
	
    public void setTaskDescription(String taskDescription) {
    	//input validation - description must be between 1 and 50 characters
    	if (taskDescription!= null && taskDescription.length() <= 50) {
            this.taskDescription = taskDescription;
        }
        else {
        	throw new IllegalArgumentException("Invalid description");
        }
    }	
}