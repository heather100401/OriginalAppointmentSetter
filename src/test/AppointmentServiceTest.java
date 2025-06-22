package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;


import Appointment.Appointment;
import Appointment.AppointmentService;

class AppointmentServiceTest {
	
	Date pass = new Date (125,4,12);
	Date fail = new Date (122,4,12);
	
	Appointment appointment = new Appointment("1234", pass, "Description");
	
	AppointmentService appointmentService = new AppointmentService();

	@Test
	void testAddAppointmentID() {
		appointmentService.addAppointment(appointment);
		assertTrue(appointmentService.getAppointmentID(appointment.getAppointmentID()).equals("1234"));
	}
	
	@Test
	void testAddAppointmentDate() {
		appointmentService.addAppointment(appointment);
		assertTrue(appointmentService.getDate(appointment.getAppointmentID()).equals(pass));
	}
	
	@Test
	void testAddAppointmentDescription() {
		appointmentService.addAppointment(appointment);
		assertTrue(appointmentService.getDescription(appointment.getAppointmentID()).equals("Description"));
	}

	
	@Test
	void testAddExistingAppointment() {
		appointmentService.addAppointment(appointment);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(appointment);
		});
	}
	
	@Test
	void testDeleteTask() {
		appointmentService.addAppointment(appointment);
		appointmentService.deleteAppointment("1234");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.getAppointmentID(appointment.getAppointmentID());
		});

	}
	
	@Test
	void testDeleteNullTask() {
		appointmentService.addAppointment(appointment);
		appointmentService.deleteAppointment("1234");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.deleteAppointment("1234");
		});
	}
	
	
}
