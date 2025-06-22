package test;

import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;

import java.util.Date;

class AppointmentTest {
	
	Date pass = new Date(125,4,12);
	Date fail = new Date (122,4,12);
	

	@Test
	void testAppointmentID() {
		Appointment appointment = new Appointment("123", pass, "Test Appointment ID");
		assertTrue(appointment.getAppointmentID().equals("123"));
	}
	
	@Test
	void testAppointmentDate() {
		Appointment appointment = new Appointment("123", pass, "Test Appointment Date");
		assertTrue(appointment.getDate().equals(pass));
	}
	
	@Test
	void testAppointmentDescription() {
		Appointment appointment = new Appointment("123", pass, "Test Appointment Description");
		assertTrue(appointment.getDescription().equals("Test Appointment Description"));
	}
	
	@Test
	void testLongID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345678910111213", pass, "Test Appointment ID");
			});
	}
	
	@Test
	void testNullID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, pass, "Test Appointment ID");
			});
		
	}
	
	@Test
	void testNullDate() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567", null, "Test Appointment Date");
			});
		
	}
	
	@Test
	void testBadDate() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567", fail, "Test Appointment Date");
			});
		
	}
	
	@Test
	void testLongDescription() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123", pass, "Testing the longer Appointment Descriptionnnnnnnnnnnnnnn");
			});
	}
	
	@Test
	void testNullDescription() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123", pass, null);
			});
	}
	
	@Test
	void testSetDate() {
		Date testDate = new Date (125,6,15);
		Appointment appointment = new Appointment("1234567", pass, "Test Appointment Date");
		appointment.setDate(testDate);
		assertTrue(appointment.getDate().equals(testDate));
	}
	
	@Test
	void testSetNullDate() {
		Appointment appointment = new Appointment("1234567", pass, "Test Appointment Date");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointment.setDate(null);
			});
	}
	
	@Test
	void testSetDescription() {
		Appointment appointment = new Appointment("1234567", pass, "Test Appointment Description");
		appointment.setDescription("New description");
		assertTrue(appointment.getDescription().equals("New description"));
	}
	
	@Test
	void testSetNullDescription() {
		Appointment appointment = new Appointment("1234567", pass, "Test Appointment Description");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointment.setDescription(null);
			});
	}
	

}

