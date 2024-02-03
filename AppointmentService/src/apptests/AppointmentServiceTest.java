package apptests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import org.junit.jupiter.api.Test;

import appointments.Appointment;
import appointments.AppointmentService;

class AppointmentServiceTest {
	//local variables
	private AppointmentService service;
	private Calendar testDate = new GregorianCalendar(2023, 9, 24); //static date for testing
	private Date validDate = testDate.getTime(); //creating date object using static calendar date
	private Appointment appointment1;
	private Appointment appointment2;
	
	@BeforeEach
	public void setUp() {
		service = new AppointmentService();
		appointment1 = new Appointment("A1", validDate, "Appointment 1");
		appointment2 = new Appointment("A2", validDate, "Appointment 2");
	}

	@Test
	void testAddAppointment() {
		//adding a new Appointment
		service.addAppointment(appointment1);
		Map<String, Appointment> appointments = service.getAppointments();
		//makes sure only one appointment is added
		assertEquals(1, appointments.size());
		//makes sure appointment 1 is added correctly
		assertTrue(appointments.containsKey("A1"));
		assertEquals(appointment1, appointments.get("A1"));
	}
	
	@Test
	void testAddDuplicateAppointment() {
		//adding appointment 1
		service.addAppointment(appointment1);
		//adding appointment 1 AGAIN should throw exception
		assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appointment1));
		Map<String, Appointment> apps = service.getAppointments();
		//the size of the HashMap should be only 1
		assertEquals(1, apps.size());
	}
	
	@Test
	void testDeleteAppointment() {
		//adding two appointments
		service.addAppointment(appointment1);
		service.addAppointment(appointment2);
		//delete one of the appointments by ID number
		service.deleteAppointment(appointment1.getApptId());
		Map<String, Appointment> appointments = service.getAppointments();
		//checking that one appointment got deleted, the other still exists
		assertEquals(1, appointments.size());
		assertFalse(appointments.containsKey(appointment1.getApptId()));
		assertTrue(appointments.containsKey(appointment2.getApptId()));
	}
	
	@Test
	void testDeleteNonExistentAppointment() {
		//adding one appointment
		service.addAppointment(appointment1);
		//deleting an appointment that does not exist should throw exception
		assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment(appointment2.getApptId()));
		Map<String, Appointment> appointments = service.getAppointments();
		//checking that no appointments got deleted
		assertEquals(1, appointments.size());
	}
}
