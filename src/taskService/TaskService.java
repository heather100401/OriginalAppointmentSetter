package taskService;

import java.util.HashMap;
import java.util.Map;

public class TaskService {

    private Map<String, Task> tasks;

    public TaskService() {
        tasks = new HashMap<>();
    }

    // Add a new task
    public void addTask(Task task){
        if (tasks.containsKey(task.getTaskID())){
            throw new IllegalArgumentException("Task ID already exists");
        }
        tasks.put(task.getTaskID(), task);
    }

    // Delete a task
    public void deleteTask(String taskID){
        if(!tasks.containsKey(taskID)){
            throw new IllegalArgumentException("Task ID not found");
        }
        tasks.remove(taskID);
    }

    // Update name
    public void updateName(String taskID, String name){
        Task task = getTask(taskID);
        task.setName(name);
    }

    // Update description
    public void updateDescription(String taskID, String description){
        Task task = getTask(taskID);
        task.setDescription(description);
    }
    
    public String getTaskID(String taskID) {
    	Task task = getTask(taskID);
    	return task.getTaskID();
    }
    
    public String getName(String taskID) {
    	Task task = getTask(taskID);
    	return task.getName();
    }
    
    public String getDescription(String taskID) {
    	Task task = getTask(taskID);
    	return task.getDescription();
    }


    // Helper method to get a task by ID
    private Task getTask(String taskID){
        Task task = tasks.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found");
        }
        return task;
    }
    
}
