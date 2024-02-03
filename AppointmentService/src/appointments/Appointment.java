/*
 * CS 320 Module Five Milestone
 * @author Janai Cano
 * @date 06-01-2023
 */

package appointments;

import java.util.Date;

public class Appointment {
	//local variables
	private final String appointmentId; //cannot be changed
	private Date appointmentDate;
	private String appointmentDesc;
	
	public Appointment(String appointmentId, Date appointmentDate, String appointmentDesc) {
		//initializing ID - cannot be changed once entered
		if (appointmentId ==null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("Appointment ID cannot be null or longer than 10 characters.");
		}
		else {
			this.appointmentId = appointmentId;
		}
		
		//setting other variables
		setAppointmentDate(appointmentDate);
		setAppointmentDesc(appointmentDesc);
		
	}

	//Getters
	public String getApptId() {
		return appointmentId;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getAppointmentDescription() {
		return appointmentDesc;
	}
	
	//Setters
	public void setAppointmentDate(Date appointmentDate) {
		Date today = new Date();
		if (appointmentDate == null) {
			throw new IllegalArgumentException("Appointment date cannot be null");
		}
		else {
			if (appointmentDate.before(today)) {	
				throw new IllegalArgumentException("Appointment date cannot be in the past");
			}
			else {
				this.appointmentDate = appointmentDate;
			}
		}
	}

	public void setAppointmentDesc(String appointmentDesc) {
		if (appointmentDesc == null) {
			throw new IllegalArgumentException("Description cannot be null");
		}
		else {
			if (appointmentDesc.length() > 50) {
				throw new IllegalArgumentException("Description too long");
			}
			else {
				this.appointmentDesc = appointmentDesc;
			}
		}
	}	
}
