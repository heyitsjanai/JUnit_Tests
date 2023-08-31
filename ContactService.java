/*					
* SNHU CS-320 Module Three Milestone 				    
* Author: @heyitsJanai                                               
* Date: 05-20-2023                               
*/

package cs_320_mod3_milestone;

/* This is the ContactService class, 
*  which provides all CRUD methods for Contact objects. */

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	//HashMap stores the contacts
    protected Map<String, Contact> contacts;
    
    public ContactService() {
        this.contacts = new HashMap<>();
    }
    
    //function to ADD a new contact
    public void addContact(Contact contact) {
    	//make sure the contact is not null
    	if (contact != null) {
    		//get the contact id from the contact object
            String contactId = contact.getId();
            //make sure the contact id is not already in contacts
            if (!contacts.containsKey(contactId)) {
            	//if not, contact is added to the HashMap
                contacts.put(contactId, contact);
                System.out.println("Contact added successfully.");
            } 
            //if contact already exists, throw exception
            else {
                throw new IllegalArgumentException("Contact with ID " + contactId + " already exists.");
            }
        } 
    	//if contact is null, throw exception
        else {
            throw new IllegalArgumentException("Contact cannot be null.");
        }
    }
    
    //function to DELETE a contact
    public void deleteContact(String contactId) {
    	//checks if the contact exists in HashMap
        if (contactId != null && contacts.containsKey(contactId)) {
        	//if so, contact is removed from the HashMap
            contacts.remove(contactId);
            System.out.println("Contact with ID " + contactId + " deleted successfully.");
        } 
        //if contact does not exist, throw exception
        else {
            throw new IllegalArgumentException("Contact with ID " + contactId + " does not exist.");
        }
    }
    
    //function to UPDATE a contact field -- user must specify what field to be updated
    public void updateContactField(String contactId, String field, String value) {
    	//checks if the contact exists in HashMap
        if (contactId != null && contacts.containsKey(contactId)) {
        	//if it exists in HashMap, contact is retrieved
            Contact contact = contacts.get(contactId);
            //checks for the user-specified field to be updated
            switch (field) {
                case "firstName":
                	//updates the contact's first name with the specified value
                    contact.setFirstName(value);
                    break;
                case "lastName":
                	//updates the contact's last name with the specified value
                    contact.setLastName(value);
                    break;
                case "phone":
                	//updates the contact's phone number with the specified value
                    contact.setPhone(value);
                    break;
                case "address":
                	//updates the contact's address with the specified value
                    contact.setAddress(value);
                    break;
                default:
                	//default case is to throw exception since any other contact field does not exist
                	throw new IllegalArgumentException("Contact field " + field + " does not exist.");
            }
            //once updated, user is notified
            System.out.println("Contact field " + field + " updated successfully.");
        } 
        //if contact does not exist, throw exception
        else {
            throw new IllegalArgumentException("Contact with ID " + contactId + " does not exist.");
        }
    }
    
    //function to RETURN the HashMap of contacts
	public Map<String, Contact> getContacts() {
		return contacts;
	}
    
}
           
