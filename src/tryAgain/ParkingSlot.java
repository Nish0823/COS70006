package tryAgain;



/**
 * This class represents a parking slot 
 * 
 * @author Nishant Sharma (103635243)
 * @version 1.0 25/08/2021
 */ 

public class ParkingSlot {
	private String slotID;
	private Car cars; 
	private boolean isStaff; 
	
	/**
	 * Constructor for objects if class ParkingSLot
	 * 
	 * @param slotID a string representation of unique slot id's
	 */
	public ParkingSlot(String slotID, boolean isStaff) {
			this.slotID = slotID;  
			this.cars = null;//set the car object from Car class to null 
			this.isStaff = isStaff;
		}

	/**
	 * A getter method to return the cars object
	 * @return cars object inside the parking slot
	 */
	public Car getCars() {
		return cars;
		}
	
	
	/*
	 * A method to add a Car object to the ParkingSlot object
	 * @param car, which is a Car object
	 */
	public void addCar(Car car) {
		this.cars = car;
		}
	
	
	/*
	 * A setter method to set the slot id
	 * @param String slot id
	 */
	public void setSlotID(String slotID) {
		this.slotID = slotID;
		
	}

	/*
	 * method to remove car from slot which sets it back to null 
	 */
	public void removeCar() { 
			this.cars = null;
	}
		
	/*
	 * method to return a string of the slot id
	 */
	public String getSlotID() {
		return slotID;
	}
	
	
	/*
	 * method to return a boolean isStaff
	 */
	public boolean isStaff() {
		return isStaff;
	}
	
	
	/*
	 * method to set boolean isStaff
	 */
	public void setStaff(boolean isStaff) {
		this.isStaff = isStaff;
	}

	/*
	 * method to check whether slot is empty or not
	 */
	public boolean isEmpty() {
		return this.cars != null;
	}

	/*
	 * override Object toString to get a string representation of the instance variables of this class 
	 */
	@Override
	public String toString() {
		return String.format("Car Details : %s || Slot Number : %s ",cars,slotID);
	}


}
	


