/*					
* SNHU CS-320 Module Three Milestone 				    
* Author: @heyitsJanai                                               
* Date: 05-20-2023                               
*/

package tests;

/* This class runs JUnit tests for the ContactService class.
*  I achieved over 80% testing coverage using these tests. */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import cs_320_mod3_milestone.Contact;
import cs_320_mod3_milestone.ContactService;
import java.util.Map;

public class ContactServiceTest {
    private ContactService contactService;
    private Contact contact1;
    private Contact contact2;

    //setting up valid contacts
    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
        contact1 = new Contact("007", "Han", "Solo", "1234567890", "123 Galaxy Far Away St");
        contact2 = new Contact("002", "Whitney", "Houston", "9876543210", "456 Elm St., Hollywood, CA");
    }

    //function to test contacts can be added correctly
    @Test
    public void testAddContact() {
    	//adding contact1
        contactService.addContact(contact1);
        Map<String, Contact> contacts = contactService.getContacts();
        //testing to make sure contact1 was added correctly
        assertEquals(1, contacts.size());
        assertTrue(contacts.containsKey("007"));
        assertEquals(contact1, contacts.get("007"));
        //adding contact2
        contactService.addContact(contact2);
        contacts = contactService.getContacts();
        //testing to make sure contact2 was added correctly
        assertEquals(2, contacts.size());
        assertTrue(contacts.containsKey("002"));
        assertEquals(contact2, contacts.get("002"));
    }

    //function to test for duplicate contacts
    @Test
    public void testAddContact_DuplicateId() {
    	//adding contact1
        contactService.addContact(contact1);
        //trying to add contact1 again, should throw an exception
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact1));
        Map<String, Contact> contacts = contactService.getContacts();
        //making sure contact1 was only added once
        assertEquals(1, contacts.size());
    }

    //function to test deleting contacts
    @Test
    public void testDeleteContact() {
    	//adding two contacts
        contactService.addContact(contact1);
        contactService.addContact(contact2);
        //deleting contact1
        contactService.deleteContact("007");
        Map<String, Contact> contacts = contactService.getContacts();
        //testing to make sure contact1 was deleted, but contact2 still exists
        assertEquals(1, contacts.size());
        assertFalse(contacts.containsKey("007"));
        assertTrue(contacts.containsKey("002"));
        assertEquals(contact2, contacts.get("002"));
    }

    //function to delete a non-existent contact
    @Test
    public void testDeleteContact_NonExistentId() {
    	//adding two contacts
        contactService.addContact(contact1);
        contactService.addContact(contact2);
        Map<String, Contact> contacts = contactService.getContacts();
        //testing to delete invalid contact, should throw an exception
        assertThrows(IllegalArgumentException.class, () ->contactService.deleteContact("123"));
        //making sure original two contacts still exist, were not deleted
        assertEquals(2, contacts.size());
        assertTrue(contacts.containsKey("007"));
        assertTrue(contacts.containsKey("002"));
    }

    //test to update first name 
    @Test
    public void testUpdateContactField_FirstName() {
    	//adding contact1
        contactService.addContact(contact1);
        //updating contact1 firstName field from 'Han' to 'Obi'
        contactService.updateContactField("007", "firstName", "Obi");
        Map<String, Contact> contacts = contactService.getContacts();
        //testing to make sure contact1 was updated
        assertEquals("Obi", contacts.get("007").getFirstName());
    }

    //test to update last name
    @Test
    public void testUpdateContactField_LastName() {
    	//adding contact1
        contactService.addContact(contact1);
        //updating contact1 lastName field from 'Solo' to 'Wan'
        contactService.updateContactField("007", "lastName", "Wan");
        Map<String, Contact> contacts = contactService.getContacts();
        //testing to make sure contact1 was updated
        assertEquals("Wan", contacts.get("007").getLastName());
    }

    //test to update phone number
    @Test
    public void testUpdateContactField_Phone() {
        //adding contact1 with original phone number
    	contactService.addContact(contact1);
        //updating contact1 phone number
        contactService.updateContactField("007", "phone", "1111111111");
        Map<String, Contact> contacts = contactService.getContacts();
        assertEquals("1111111111", contacts.get("007").getPhone());
    }

    //test to update address
    @Test
    public void testUpdateContactField_Address() {
        //adding contact1 with original address
    	contactService.addContact(contact1);
    	//updating contact1 address
        contactService.updateContactField("007", "address", "789 Tattoine Ln.");
        Map<String, Contact> contacts = contactService.getContacts();
        //testing to ensure contact1 address was updated
        assertEquals("789 Tattoine Ln.", contacts.get("007").getAddress());
    }

    //test to update invalid field, such as email
    @Test
    public void testUpdateContactField_InvalidField() {
    	//adding contact1
        contactService.addContact(contact1);
        //testing to update invalid field - should throw exception
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContactField("007", 
        																					"email", 
        																					"hansolo@starwars.com"));
    }

    //test to update non-existent contact
    @Test
    public void testUpdateContactField_NonExistentId() {
    	//adding contact1
        contactService.addContact(contact1);
        //testing to update non-existent contact - should throw exception
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContactField("9876543210", 
        																					 "firstName", 
        																					 "Jane"));
    }
}
