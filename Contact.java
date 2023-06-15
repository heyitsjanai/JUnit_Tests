
//					  SNHU CS-320 Module Three Milestone 				    //
//         Author: 				Janai Cano                                  //
//         Date: 				05-20-2023                                  //

package cs_320_mod3_milestone;

public class Contact {
	//declaring local variables
	private final String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		//setting id -- ID cannot be changed once set and added to HashMap
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
        }
		else {
			this.id = id;
		}
		//setting all other variables
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}
	//Getters
	public String getId() {
        return id;
    }
	
	public String getFirstName() {
        return firstName;
    }

	public String getLastName() {
        return lastName;
    }
	
	public String getPhone() {
        return phone;
    }
	
	public String getAddress() {
        return address;
    }
	//Setters
	public void setFirstName(String firstName) {
		//input validation - firstName must be between 1 and 10 characters
		if (firstName != null && firstName.length() <= 10) {
			this.firstName = firstName;
		}
		else {
			throw new IllegalArgumentException("Invalid first name");
		}
	}
	
    public void setLastName(String lastName) {
    	//input validation - lastName must be between 1 and 10 characters
    	if (lastName!= null && lastName.length() <= 10) {
            this.lastName = lastName;
        }
        else {
        	throw new IllegalArgumentException("Invalid last name");
        }
    }

	public void setPhone(String phone) {
		//input validation - phone must be between 1 and 10 characters
		if (phone!= null && phone.length() <= 10) {
            this.phone = phone;
        }
        else {
        	throw new IllegalArgumentException("Invalid phone number");
        }
	}
	
	public void setAddress(String address) {
		//input validation - address must be between 1 and 30 characters
		if (address!= null && address.length() <= 30) {
            this.address = address;
        }
        else {
        	throw new IllegalArgumentException("Invalid address");
        }
	}
	

}
