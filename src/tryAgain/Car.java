package tryAgain;



/**
 * This class represents a car obejct
 * @author Nishant Sharma (103635243)
 * @version 1 01/09/2021
 */
public class Car {
	private String registrationNumber; 
	private boolean isStaff;
	private String owner; 
	
	/**
	 * Constructor for object of class Car
	 * @param registrationNumber initialises a registration number
	 * @param isStaff initialises a boolean whether it is a staff or not
	 * @param owner initialises a name for the car owner
	 */
	public Car(String registrationNumber, String owner) {
		this.registrationNumber = registrationNumber;
		
		this.owner = owner ; 
	}
	
	/**
	 * A getter method to return the car registration number	
	 * @return registration number
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}


	/**
	 * A setter method to set a registration number
	 * @param registrationNumber takes a string parameter and set it as registration number
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}


	/**
	 * A getter method to return boolean type for staff or not	
	 * @return whether it is staff or not
	 */
	public boolean isStaff() {
		return isStaff;
	}

	/**
	 * A setter method to set a boolean type for staff
	 * @param isStaff sets boolean true or false for staff or not
	 */
	public void setStaff(boolean isStaff) {
		this.isStaff = isStaff;
	}


	/**
	 * A getter method to return owner name 	
	 * @return string of owner name
	 */
	public String getOwner() {
		return owner;
	}


	/**
	 * A setter method to set name of car owner
	 * @param owner takes a string from user and set the owner name for the car
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	
	 /**
     * An method to return a String representation of a car object
     * 
     * @return String an object containing car details
     * 
     */
	public String toString() {
		return String.format("Registration No : %s || Staff(true)/Visitor(false) : %s || Name : %s",registrationNumber,isStaff,owner);
	}

}

