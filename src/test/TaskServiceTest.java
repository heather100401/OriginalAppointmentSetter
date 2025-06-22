package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Task.Task;
import Task.TaskService;

class TaskServiceTest {
	
	Task Task1 = new Task("001", "Task1", "Test task 1");
	Task Task2 = new Task("002", "Task2", "Test task 2");
	Task Task3 = new Task("001", "Task3", "Test task 3");
	
	TaskService taskService = new TaskService();

	
	@Test
	void testAddTaskID() {
		taskService.addTask(Task1);
		assertTrue(taskService.getTaskID(Task1.getTaskID()).equals("001"));
	}
	
	@Test
	void testAddTaskName() {
		taskService.addTask(Task1);
		assertTrue(taskService.getName(Task1.getTaskID()).equals("Task1"));
	}
	
	@Test
	void testAddTaskDescription() {
		taskService.addTask(Task1);
		assertTrue(taskService.getDescription(Task1.getTaskID()).equals("Test task 1"));
	}
	
	
	
	@Test
	void testAddExistingTask() {
		taskService.addTask(Task1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(Task1);
		});
	}
	
	
	@Test
	void testDeleteTask() {
		taskService.addTask(Task2);
		taskService.deleteTask("002");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.deleteTask("002");
		});
	}
	
	@Test
	void testGetDeletedTask() {
		taskService.addTask(Task2);
		taskService.deleteTask("002");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.getTaskID(Task2.getTaskID());
		});
	}
	
	
	@Test
	void testUpdateName() {
		taskService.addTask(Task1);
		taskService.updateName("001", "New Name");
		assertTrue(taskService.getName(Task1.getTaskID()).equals("New Name"));
	}
	
	@Test
	void testUpdateDescription() {
		taskService.addTask(Task1);
		taskService.updateDescription("001", "New Description");
		assertTrue(taskService.getDescription(Task1.getTaskID()).equals("New Description"));
	}
	
}
