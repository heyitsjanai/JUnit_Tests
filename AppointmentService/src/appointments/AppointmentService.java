/*
 * CS-320 Module Five Milestone
 * @author Janai Cano
 * @date 06-01-2023
 */

package appointments;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	//creating local HashMap to store appointments
	protected Map<String, Appointment> appointments;
	
	public AppointmentService() {
		this.appointments = new HashMap<>();
	}
	
	//add new appointments to the HashMap
	public void addAppointment(Appointment appointment) {
		if (appointment != null) {
			String appointmentId = appointment.getApptId();
			if (appointments.containsKey(appointmentId) ) {
				throw new IllegalArgumentException("Appointment with id " + appointmentId + " already exists.");
			}
			else {
				appointments.put(appointmentId, appointment);
				System.out.println("Appointment added successfully");
			}
		}
		else {
			throw new IllegalArgumentException("Appointment ID cannot be null.");
		}
	}
	
	//delete appointment from the HashMap
	public void deleteAppointment(String appointmentId) {
		if (appointmentId != null && appointments.containsKey(appointmentId)) {
			appointments.remove(appointmentId);
			System.out.println("Appointment deleted successfully");
		}
		else {
			throw new IllegalArgumentException("Appointment ID " + appointmentId + " does not exist");
		}
	}
	
	public Map<String, Appointment> getAppointments() {
		return appointments;
	}

}
