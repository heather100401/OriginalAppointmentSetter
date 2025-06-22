package appointmentService;

import java.util.Date;

public class Appointment {
	private final String appointmentID; // unique, cannot be updated, max length 10
    private Date date; // cannot be null, cannot be in the past
    private String description; // cannot be null, max length 50
    
    public Appointment(String appointmentID, Date date, String description){
        if (appointmentID == null || appointmentID.length() > 10){
            throw new IllegalArgumentException("Error: Appointment ID must be non-null and cannot exceed 10 characters.");
        } else{
            this.appointmentID = appointmentID;
        }

        if (date == null || date.before(new Date())) {
            throw new IllegalArgumentException("Error: Appointment date must be non-null and cannot be in the past.");
        } else{
            this.date = date;
        }

        if (description == null || description.length() > 50){
            throw new IllegalArgumentException("Error: Appointment description must be non-null and cannot exceed 50 characters.");
        } else{
            this.description = description;
        }
    }
    
    
    
 // Getters

    public String getAppointmentID() {
        return appointmentID;
    }
    public Date getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }

   
    //Setters

    public void setDate(Date date){	
    	if (date == null || date.before(new Date())) {
            throw new IllegalArgumentException("Error: Appointment date must be non-null and cannot be in the past.");
        } else{
            this.date = date;
        }
    }

    public void setDescription(String description){
        if (description == null || description.length() > 50){
            throw new IllegalArgumentException("Error: Appointment description must be non-null and cannot exceed 50 characters.");
        } else{
            this.description = description;
        }
    }
}
