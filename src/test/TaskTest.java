package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Task.Task;

class TaskTest {
	
	@Test
	void testTaskID() {
		Task task = new Task("123", "Task1", "Test Task");
		assertTrue(task.getTaskID().equals("123"));
	}
	
	@Test
	void testTaskName() {
		Task task = new Task("123", "Task1", "Test Task");
		assertTrue(task.getName().equals("Task1"));
	}
	
	@Test
	void testTaskDescription() {
		Task task = new Task("123", "Task1", "Test Task");
		assertTrue(task.getDescription().equals("Test Task"));
	}

	@Test
	void testNullTaskID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Name", "Description");
			});
	}
	
	@Test
	void testLongTaskID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456789101112", "Name", "Description");
			});
	}
	
	
	@Test
	void testNullName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123", null, "Description");
			});
	}
	
	@Test
	void testLongName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123", "namenamenamenamenamenamenamenamename", "Description");
			});
	}
	

	@Test
	void testNullDescription() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123", "Name", null);
			});

	}
	
	@Test
	void testLongDescription() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123", "Name", "DescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescription");
			});

	}

	@Test
	void testSetName() {
		Task task = new Task("123", "Task1", "Test Task");
		task.setName("Task2");
	}
	
	@Test
	void testSetNullName() {
		Task task = new Task("123", "Task1", "Test Task");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setName(null);
		});
	}
	
	@Test
	void testSetDescription() {
		Task task = new Task("123", "Task1", "Test Task");
		task.setDescription("Test change description");
	}
	
	@Test
	void testSetNullDescription() {
		Task task = new Task("123", "Task1", "Test Task");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setDescription(null);
		});
	}

	
}

