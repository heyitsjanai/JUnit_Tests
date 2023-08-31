

/*					
* SNHU CS-320 Module Three Milestone 				    
* Author: @heyitsJanai                                               
* Date: 05-20-2023                               
*/


package tests;

/* This class tests the Contact class. Running JUnit tests, 
*  I achieved over 80% coverage using this class. */
	
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cs_320_mod3_milestone.Contact;

class ContactTest {
	private Contact contact;

	//setting up a valid contact object before each test
	@BeforeEach
	public void setUp() {
		contact = new Contact("01", "Janai", "Smith", "4323499999", "123 Main St., Austin, TX 78702");
	}

	//testing to make sure that the object is created properly
	@Test
	void testContactClass() {
		assertTrue(contact.getId().equals("01"));
		assertTrue(contact.getFirstName().equals("Janai"));
		assertTrue(contact.getLastName().equals("Cano"));
		assertTrue(contact.getPhone().equals("4323499999"));
		assertTrue(contact.getAddress().equals("123 Main St., Austin, TX 78702"));
	}

	//testing to make sure exception is thrown when firstName is null
	@Test
	void testContactWithNoFirstName() {
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
	}


	//testing to make sure exception is thrown when lastName is null
	@Test
        void testContactWithNoLastName() {
		assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
	}

	//testing to make sure exception is thrown when phone is null
	@Test
        void testContactWithNoPhone() {
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
	}

	//testing to make sure exception is thrown when address is null
	@Test
        void testContactWithNoAddress() {
		assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
	}

	//testing to make sure exception is thrown when firstName is over allowed char count
	@Test
	void testContactFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("Tikkitikkitimbonosaremboterriberri"));
	}
}
