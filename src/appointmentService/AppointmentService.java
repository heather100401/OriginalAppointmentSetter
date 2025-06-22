package appointmentService;

import java.util.HashMap;
import java.util.Map;


import java.util.Date;


public class AppointmentService {
	
	private Map<String, Appointment> appointments;


	public AppointmentService() {
		appointments = new HashMap<>();
	}
	
	// Add a new appointment
    public void addAppointment(Appointment appointment){
        if (appointments.containsKey(appointment.getAppointmentID())){
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        appointments.put(appointment.getAppointmentID(), appointment);
    }
    
 // Delete an appointment
    public void deleteAppointment(String appointmentID){
        if(!appointments.containsKey(appointmentID)){
            throw new IllegalArgumentException("Appointment ID not found");
        }
        appointments.remove(appointmentID);
    }
	
	public String getAppointmentID(String appointmentID) {
    	Appointment appointment = getAppointment(appointmentID);
    	return appointment.getAppointmentID();
    }
	
	public Date getDate(String appointmentID) {
    	Appointment appointment = getAppointment(appointmentID);
    	return appointment.getDate();
    }
	
	public String getDescription(String appointmentID) {
    	Appointment appointment = getAppointment(appointmentID);
    	return appointment.getDescription();
    }
	
    // Helper method to get a task by ID
    private Appointment getAppointment(String appointmentID){
        Appointment appointment = appointments.get(appointmentID);
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment ID not found");
        }
        return appointment;
    }

}
