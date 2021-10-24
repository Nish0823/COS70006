package tryAgain;

import java.util.ArrayList;

/**
 * This class represents a car park obejct
 * @author Nishant Sharma (103635243)
 * @version 1 03/09/2021
*/


public class CarPark {
	/**
	 * instantiates a new ParkingSlot  as an array list 
	 */
	private ArrayList <ParkingSlot> parkingSlots =  new ArrayList<>();
	

	/**
     * A method to add a ParkingSlot object to the list of parking slots
     * 
     * @param slots a ParkingSlot object
     * 
     */
	public void addSlotsinCarPark(ParkingSlot slots) {
		parkingSlots.add(slots);

	}
	
	 /**
     * A method to find a specific PakingSlot object given parking slot id
     * 
     * @param slotNumber the identification number of the parking slot to be searched
     * @return a ParkingSlot object p that matches slot id or null
     * 
     */
	public ParkingSlot findSlot(String slotNumber)
    {
        for(ParkingSlot p : parkingSlots)
        {
            if(p.getSlotID().equals(slotNumber))
            return p;
        }
    
        return null;
    }
	
	 /**
     * A method to find a specific PakingSlot object given the car registration number , which returns the ParkingSlot object
     * only if the car registration number is in that parking spot
     * 
     * @param carNumber  the identification number of the car to searched
     * @return a ParkingSlot object p that matches the car registration number or null
     * 
     */
	public ParkingSlot findCar(String carNumber)
    {
        for(ParkingSlot p : parkingSlots)
        {
            if(p.getCars() != null) {
            	if(p.getCars().getRegistrationNumber().equals(carNumber)) {
            		return p;
            	}
            }
            
        }
    
        return null;
    }
	
	
	/**
     * A method to remove a ParkingSlot object 
     * 
     * @param slot object that needs to be removed from the parkingSlots
     * 
     */
	public void removeSlot(ParkingSlot slot) {
		parkingSlots.remove(slot);
		
	}

	 /**
     * A method to get all ParingSlot objects in the parkingSlots
     * 
     * @return ArrayList<ParkingSlot>  an ArrayList of parkingSlot objects
     * 
     */
    public ArrayList<ParkingSlot> getAllParkingSlots()
    {
        return parkingSlots;
    }
	
    
    /**
     * method to return a list of cars by their registration number
     * @return string representation of car registration number
     */
    public ArrayList<String> getCarsintList(){
   
    	ArrayList <String> find =  new ArrayList<>();
    	
    	for(ParkingSlot p : parkingSlots) {
    		if(p.getCars() != null) {
    			find.add(p.getCars().getRegistrationNumber());
    		}
    	}
    	return find; 
    }
    
    
    /**
     * method to return a list of slot by their slot id
     * @return string representation of slot id 
     */
    public ArrayList<String> getSlotsinList(){
    	   
    	ArrayList <String> find =  new ArrayList<>();
    	
    	for(ParkingSlot p : parkingSlots) {
    		if(p.getSlotID() != null) {
    			find.add(p.getSlotID());
    		}
    	}
    	return find; 
    }
    
    /**
     * An method to return a String representation of a CarPark object
     * 
     * @return String an object containing CarPark details
     * 
     */
	public String toString() {
		
		return String.format("Slots in Car Park At The Moment - %s",parkingSlots);
		}
	

}
