

//					  SNHU CS-320 Module Three Milestone 				    //
//         Author: 				Janai Cano                                  //
//         Date: 				05-20-2023                                  //


package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//testing Contact class
import cs_320_mod3_milestone.Contact;

class ContactTest {
	private Contact contact;
	
	@BeforeEach
	public void setUp() {
		//setting up a valid contact object
		contact = new Contact("01", "Janai", "Cano", "4323499999", "123 Main St., Austin, TX 78702");
	}

	@Test
	void testContactClass() {
		//testing to make sure that the object is created properly
		assertTrue(contact.getId().equals("01"));
		assertTrue(contact.getFirstName().equals("Janai"));
		assertTrue(contact.getLastName().equals("Cano"));
		assertTrue(contact.getPhone().equals("4323499999"));
		assertTrue(contact.getAddress().equals("123 Main St., Austin, TX 78702"));
	}
	
	@Test
	void testContactWithNoFirstName() {
		//testing to make sure exception is thrown when firstName is null
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
	}

	
	@Test
    void testContactWithNoLastName() {
		//testing to make sure exception is thrown when lastName is null
		assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
	}
	
	@Test
    void testContactWithNoPhone() {
		//testing to make sure exception is thrown when phone is null
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
	}
	
	@Test
    void testContactWithNoAddress() {
		//testing to make sure exception is thrown when address is null
		assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
	}
	
	@Test
	void testContactFirstNameTooLong() {
		//testing to make sure exception is thrown when firstName is too long
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("Tikkitikkitimbonosaremboterriberri"));
	}
}
