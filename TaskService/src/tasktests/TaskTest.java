package tasktests;

//					  SNHU CS-320 Module Four Milestone 				    //
//         Author: 				Janai Cano                                  //
//         Date: 				05-26-2023                                  //
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tasks.Task;

class TaskTest {
	
	private Task task;
	
    @BeforeEach
    void setUp() {
    	//setting up a valid task object
        task = new Task("1", "Call", "Call the number for this contact");
    }
    
	@Test
	void testTaskClass() {
		//testing to make sure the object is created properly
		assertTrue(task.getTaskId().equals("1"));
		assertTrue(task.getTaskName().equals("Call"));
		assertTrue(task.getDescription().equals("Call the number for this contact"));
	}
	
	@Test
	void testTaskName() {
		//testing to make sure exception is thrown when name is null
		assertThrows(IllegalArgumentException.class, () -> task.setTaskName(null));
		//testing to make sure exception is thrown when name is too long
		assertThrows(IllegalArgumentException.class, () -> task.setTaskName("ThisNameIsWayTooLong"));
	}
	
	@Test
	void testTaskDescription() {
		//testing to make sure exception is thrown when description is null
		assertThrows(IllegalArgumentException.class, () -> task.setTaskDescription(null));
		//testing to make sure exception is thrown when description is too long
		assertThrows(IllegalArgumentException.class, () -> task.setTaskDescription("This is an example of a way too long "
																					+ "description for a task, much longer than 50 characters. "
																					+ "Task descriptions do not need to be this long"));
	}

}
