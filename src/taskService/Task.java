package taskService;

public class Task
{
    private final String taskID; // unique, cannot be updated, max length 10
    private String name; // cannot be null, max length 20
    private String description; // cannot be null, max length 50

    public Task(String taskID, String name, String description){
        if (taskID == null || taskID.length() > 10){
            throw new IllegalArgumentException("Error: Task ID must be non-null and no longer than 10 characters.");
        } else{
            this.taskID = taskID;
        }

        if (name == null || name.length() > 20){
            throw new IllegalArgumentException("Error: Task name must be non-null and no longer than 20 characters.");
        } else{
            this.name = name;
        }

        if (description == null || description.length() > 50){
            throw new IllegalArgumentException("Error: Task description must be non-null and no longer than 50 characters.");
        } else{
            this.description = description;
        }
    }


    // Getters

    public String getTaskID() {
        return taskID;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    //Setters

    public void setName(String name){
        if (name == null || name.length() > 20){
            throw new IllegalArgumentException("Error: Task name must be non-null and no longer than 20 characters.");
        } else{
            this.name = name;
        }
    }

    public void setDescription(String description){
        if (description == null || description.length() > 50){
            throw new IllegalArgumentException("Error: Task description must be non-null and no longer than 50 characters.");
        } else{
            this.description = description;
        }
    }
}
