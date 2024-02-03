package apptests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Date;
import java.util.GregorianCalendar; //for testing
import java.util.Calendar;         //for testing
import appointments.Appointment;

class AppointmentTest {
	//local variables
	private Appointment appointment;
	private Calendar testDate = new GregorianCalendar(2023, 9, 24); //static date for testing
	private Date validDate = testDate.getTime(); //creating date object using static calendar date
	
	@BeforeEach
	void setUp() {
		//creating valid appointment before testing
		appointment = new Appointment("A1", validDate , "Sister's birthday");
	}

	@Test
	void testAppointmentClass() {
		//testing ID is set correctly
		assertTrue(appointment.getApptId().equals("A1"));
		//testing Date is set correctly
		assertTrue(appointment.getAppointmentDate().equals(validDate));
		//testing description is set correctly
		assertTrue(appointment.getAppointmentDescription().equals("Sister's birthday"));
	}
	
	@Test
	void testAppointmentDate() {
		//should throw exception when date is null
		assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(null));
		Calendar testDate1 = new GregorianCalendar(2021, 1, 8); // date in the past
		Date invalidDate = testDate1.getTime(); //date object with invalid past date
		//should throw exception when date is in the past
		assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(invalidDate));
	}
	
	@Test
	void testAppointmentDesc() {
		//should throw exception when description is null
		assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDesc(null));
		//should throw exception when description is longer than 50 characters
		assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDesc("Super long, invalid description of this appointment."));
	}

}
