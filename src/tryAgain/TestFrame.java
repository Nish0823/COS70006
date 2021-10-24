package tryAgain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.*;

/**
 * This class implements the GUI for the parking Slot System along with logic to handle user input for our application 
 * @author Nishant Sharma (103635243)
 * @version 1 22/10/2021
 */


public class TestFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private int visitorInt;
	private int staffInt;
	private CarPark carPark1 = new CarPark();
	private Map<String, JButton> buttonMap = new LinkedHashMap<>();
	JPanel p; //panel for add car
	JPanel x; //panel for remove car
	JPanel findCarPanel; //panel to find car
	JPanel removeSlotPanel; 
	JPanel panelForSlots;
	JPanel panelForVisitorSlots;
	JPanel addSlotComponent;
	
	/**
	 * Constructor for JFrame object which executes two methods for user input
	 */
	public TestFrame() {
		askForSlots();
		myMainFrame();
	}
	
	/**
	 * method to take user input for the number of visitor and staff slots
	 */
	public void askForSlots() {
		while (true) {
			String checkString = "^[0-9]*$";
			String visitorValue = JOptionPane.showInputDialog("Please input a visitor value");
			String staffValue = JOptionPane.showInputDialog("Please input a staff value");
			
			if(visitorValue.matches(staffValue) && staffValue.matches(checkString)) {
				visitorInt = Integer.parseInt(visitorValue);
				staffInt = Integer.parseInt(staffValue);
				break;
			}else {
				JOptionPane.showMessageDialog(this, "Please Enter a Number");
			}
		}
		
		
		
	}
	
	/**
	 * method to create the main JFrame window with various layouts and components for different panels 
	 */
	public void myMainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//panel with all the optins
		JPanel optionsPanel = new JPanel();
	
		
		//center panel for the two slots
		JPanel slotPanel = new JPanel();
		slotPanel.setLayout(new GridLayout(0,2));
		
		
		//Staff Panel on the left 
		JPanel staffPanel = new JPanel();
		staffPanel.setBackground(Color.white);
		staffPanel.setLayout(new BorderLayout());
		slotPanel.add(staffPanel);
		
		
		JPanel staffHeader = new JPanel();
		staffHeader.setBackground(Color.gray);
		
		JLabel forStaff = new JLabel("Staff Slot");
		forStaff.setFont(new Font("Calibri", Font.BOLD, 20));
		staffHeader.add(forStaff);
		staffPanel.add(staffHeader,BorderLayout.NORTH);
		
		panelForSlots = new JPanel();
		panelForSlots.setLayout(new GridLayout(0,2));
		staffPanel.add(panelForSlots);
			
		//visitor panel on the right 
		JPanel visitorPanel = new JPanel();
		visitorPanel.setBackground(Color.yellow);
		visitorPanel.setLayout(new BorderLayout());
		slotPanel.add(visitorPanel);
		
		
		JPanel visitorHeader = new JPanel();
		visitorHeader.setBackground(Color.darkGray);
		
		JLabel forVisitor = new JLabel("Visitor Slot");
		forVisitor.setFont(new Font("Calibri", Font.BOLD, 20));
		visitorHeader.add(forVisitor);
		visitorPanel.add(visitorHeader,BorderLayout.NORTH);
		
		panelForVisitorSlots = new JPanel();
		panelForVisitorSlots.setLayout(new GridLayout(0,2));
		visitorPanel.add(panelForVisitorSlots);
		
		
		
		optionsPanel.setBackground(Color.green);
		
//	
//		JButton listSlot = new JButton("List Slots");
//		optionsPanel.add(listSlot);
//		listSlot.addActionListener(e->{
//			panelForSlots.revalidate();
//
//			
//		});
		
		JButton addCar = new JButton("Add Car");
		JButton removeCar = new JButton("Remove Car");
		JButton findCar = new JButton("Find Car");
		JButton removeSLot = new JButton("Remove SLot");
		JButton addSlot = new JButton("Add Slot");
		
		optionsPanel.add(addCar);
		addCar.addActionListener(e->{
			componentForAddCar();
			addCar.setEnabled(false);
			removeCar.setEnabled(true);
			findCar.setEnabled(true);
			removeSLot.setEnabled(true);
			addSlot.setEnabled(true);
			
			
			
		});
		
		
		optionsPanel.add(removeCar);
		removeCar.addActionListener(e->{
			componentForRemoveCar();
			removeCar.setEnabled(false);
			addCar.setEnabled(true);
			findCar.setEnabled(true);
			removeSLot.setEnabled(true);
			addSlot.setEnabled(true);
			
			
		});
		
		
		optionsPanel.add(findCar);
		findCar.addActionListener(e->{
			componenetToFindCar();
			findCar.setEnabled(false);
			removeCar.setEnabled(true);
			addCar.setEnabled(true);
			removeSLot.setEnabled(true);
			addSlot.setEnabled(true);
		});
		
		
		optionsPanel.add(removeSLot);
		removeSLot.addActionListener(e->{
			componenetToRemoveSlot();
			removeSLot.setEnabled(false);
			removeCar.setEnabled(true);
			addCar.setEnabled(true);
			findCar.setEnabled(true);
			addSlot.setEnabled(true);
		});
		
		optionsPanel.add(addSlot);
		addSlot.addActionListener(e->{
			componentToAddSlot();
			addSlot.setEnabled(false);
			removeSLot.setEnabled(true);
			removeCar.setEnabled(true);
			addCar.setEnabled(true);
			findCar.setEnabled(true);
		});
		
		JButton exit = new JButton("Exit");
		
		optionsPanel.add(exit);
		
		exit.addActionListener(e->{
			System.exit(0);
		});
		
		
		
		optionsPanel.setLayout(new GridLayout(0,1));
		add(slotPanel);
		add(optionsPanel,BorderLayout.WEST);

		addSlotsStaffToPanel(panelForSlots);
		addSlotsVisitorToPanel(panelForVisitorSlots);
		pack();
		setVisible(true);
	}
	
	
	/**
	 * method to dynamically add staff slots after the program first executes 
	 * @param slotPanels a JPanel object to hold staff parking slots as JButton objects
	 */
	public void addSlotsStaffToPanel(JPanel slotPanels) {
		for (int i = 1; i <= staffInt; i++) {
		    String slotName = String.format("S%02d", i);
		    ParkingSlot slot = new ParkingSlot(slotName,true);
		    carPark1.addSlotsinCarPark(slot);


		    JButton button = new JButton(slotName + ": Empty");
		    button.setActionCommand(slotName);
		    buttonMap.put(slotName, button);
		    button.addActionListener(e ->{
		    	interActiveAddCar(slotName);
		    	System.out.println("clicked" + slotName);
		    });

		    slotPanels.add(button);
		}
	}
	
	/**
	 * method to dynamically add visitor slots after the program first executes 
	 * @param slotPanels a JPanel object to hold staff parking slots as JButton objects
	 */
	public void addSlotsVisitorToPanel(JPanel slotPanels) {
		for (int i = 1; i <= visitorInt; i++) {
		    String slotName = String.format("V%02d", i);
		    ParkingSlot slot = new ParkingSlot(slotName,false);
		    carPark1.addSlotsinCarPark(slot);
//		    slotMap.put(slotName, slot);

		    JButton button = new JButton(slotName + ": Empty");
//		    button.setActionCommand(slotName);
		    buttonMap.put(slotName, button);
		    button.addActionListener(e ->{
		    	interActiveAddCar(slotName);
		    	System.out.println("clicked" + slotName);
		    });
		    slotPanels.add(button);
		}
	}

	
	/**
	 * method to create a component that allows the user to enter car information
	 */
	public void componentForAddCar() {
		if(x != null) {
			remove(x);
		}
		
		if(findCarPanel != null) {
			remove(findCarPanel);
		}
		
		if(removeSlotPanel !=null) {
			remove(removeSlotPanel);
		}
			
		if(addSlotComponent !=null) {
			remove(addSlotComponent);
		}
		
		  p =  new JPanel();
		  
		  add(p, BorderLayout.SOUTH);
		
		  JPanel myContainer = new JPanel();
		
		  myContainer.setLayout(new BoxLayout(myContainer,BoxLayout.Y_AXIS));
		  
		  
		 
		  JPanel slotID = new JPanel();
		  slotID.setLayout(new GridLayout(0,2));
		  JLabel slotLabel = new JLabel("Enter Slot:");
		  slotID.add(slotLabel);
		  JTextField slotTextField = new JTextField();
		  slotID.add(slotTextField);
		  
		  JLabel registration = new JLabel("Registration:");
		  slotID.add(registration);
		  JTextField regoField = new JTextField();
		  slotID.add(regoField);
		  
		  JLabel ownerName = new JLabel("Name:");
		  slotID.add(ownerName);
		  JTextField nameField = new JTextField();
		  slotID.add(nameField);
		  
		  JRadioButton isStaff = new JRadioButton("Staff");
		  JRadioButton isVisitor = new JRadioButton("Visitor");
		  ButtonGroup group = new ButtonGroup();
		 
		  group.add(isStaff);
		  group.add(isVisitor);
		  
		  slotID.add(isVisitor);
		  slotID.add(isStaff);
		  
		  myContainer.add(slotID);
		  
		 
		  JButton addButton = new JButton("Add");
		  myContainer.add(addButton);
		  
		  
		
		  String regEx = "[A-Z][0-9][0-9][0-9][0-9]";
		
		  
		  addButton.addActionListener(e -> {
			  ParkingSlot slot = carPark1.findSlot(slotTextField.getText());
			  if(slot != null) {
				  if(carPark1.findCar(regoField.getText()) == null && regoField.getText().matches(regEx)){
					  if(slot.getCars() == null) {
						  if(slot.isStaff() == true && isStaff.isSelected()) {
							  JButton button = buttonMap.get(slotTextField.getText());
							  button.setText(slot.getSlotID()+"\r" + "Occupied by "+ nameField.getText() + "\r" + "Rego :" + regoField.getText());
							  buttonMap.replace(slotTextField.getText(),button);
//							  button.setOpaque(true);
							  button.setForeground(Color.red);
							  button.revalidate();
							  button.repaint();
							  slot.addCar(new Car(regoField.getText(),nameField.getText()));
						  }else if(slot.isStaff() == false && isVisitor.isSelected()) {
							  JButton button = buttonMap.get(slotTextField.getText());
							  button.setText(slot.getSlotID()+"\r" + "Occupied by "+ nameField.getText() + "\r" + "Rego :" + regoField.getText());
							  buttonMap.replace(slotTextField.getText(),button);
							  button.setForeground(Color.red);
//							  button.setOpaque(true);
//							  button.setBorderPainted(false);
							  button.revalidate();
							  button.repaint();
							  slot.addCar(new Car(regoField.getText(),nameField.getText()));
						  }else {
							  JOptionPane.showMessageDialog(this, "Please Chose the correct Slot");
						  }
						  
						  
						  }else {
							  JOptionPane.showMessageDialog(this, "Slot Currently Occupied");
						  }
					  
				  
				  }else {
					  JOptionPane.showMessageDialog(this, "Duplicate Car Registration or match Entry,Ex \"T1234\" ");
				  }
				  }else{
				  JOptionPane.showMessageDialog(this, "No Slot with this ID");
			  }
			  
			  
			});
		  
		  
		  
		  p.add(myContainer);
		  
//		  repaint();
		  revalidate();

		
		
	}
	
	/**
	 * method to create a component that allows the user to remove car from a slot
	 */
	public void componentForRemoveCar() {
		
		if(p != null ) {
			remove(p);
		}
		
		if(findCarPanel != null) {
			remove(findCarPanel);
		}
		
		if(removeSlotPanel !=null) {
			remove(removeSlotPanel);
		}
		
		if(addSlotComponent !=null) {
			remove(addSlotComponent);
		}
		
		x = new JPanel();
		add(x, BorderLayout.SOUTH);

		JPanel myContainer = new JPanel();
		
		 myContainer.setLayout(new BoxLayout(myContainer,BoxLayout.Y_AXIS));
		  
		 JPanel slotID = new JPanel();
		 slotID.setLayout(new GridLayout(0,2));
		 myContainer.add(slotID);
		 
		 JLabel slotLabel = new JLabel("Car Registration:");
		 slotID.add(slotLabel);
		  
		 JTextField regoField = new JTextField();
		 slotID.add(regoField);
		 JButton addButton = new JButton("Remove");
		 addButton.addActionListener(e->{
			 ParkingSlot findCar = carPark1.findCar(regoField.getText());
			 if(findCar != null) {
				 findCar.removeCar();
				 JButton carButton = buttonMap.get(findCar.getSlotID());
				 carButton.setForeground(null);
//				 carButton.setBorderPainted(true);
				 carButton.setText(findCar.getSlotID() + " :Empty");
				 buttonMap.replace(findCar.getSlotID(), carButton);
			 }else {
				 JOptionPane.showMessageDialog(this, "No Car with that Rego");
			 }
		 });
		 
		 myContainer.add(addButton);
		
		 x.add(myContainer);
		
		 revalidate();
	}
	
	/**
	 * method to create a component that allows the user to search where the car is parked
	 */
	public void componenetToFindCar() {
		
		if(p != null ) {
			remove(p);
		}
		
		if( x != null) {
			remove(x);
		}
		
		if(removeSlotPanel !=null) {
			remove(removeSlotPanel);
		}
		
		if(addSlotComponent !=null) {
			remove(addSlotComponent);
		}
		
		
		findCarPanel = new JPanel();
		add(findCarPanel, BorderLayout.SOUTH);

		JPanel myContainer = new JPanel();
		
		 myContainer.setLayout(new BoxLayout(myContainer,BoxLayout.Y_AXIS));
		  
		 JPanel slotID = new JPanel();
		 slotID.setLayout(new GridLayout(0,2));
		 myContainer.add(slotID);
		 
		 JLabel slotLabel = new JLabel("Car dd Registration:");
		 slotID.add(slotLabel);
		  
		 JTextField regoField = new JTextField();
		 slotID.add(regoField);
		 JButton addButton = new JButton("Find Car");
		 addButton.addActionListener(e->{
			 ParkingSlot findCar = carPark1.findCar(regoField.getText());
			 if(findCar != null) {
				 JOptionPane.showMessageDialog(this,findCar.getCars().getRegistrationNumber() + " is parked at " +findCar.getSlotID() + "Owner : " + findCar.getCars().getOwner());
			 }
		 });
		 
		 myContainer.add(addButton);
		
		 findCarPanel.add(myContainer);
		
		 revalidate();
		
	}
	
	/**
	 * method to create a component that allows the user to remove a slot if it is empty
	 */
	
	public void componenetToRemoveSlot() {
		
		if(p != null ) {
			remove(p);
		}
		
		if( x != null) {
			remove(x);
		}
		
		if(findCarPanel != null) {
			remove(findCarPanel);
		}
		
		if(addSlotComponent !=null) {
			remove(addSlotComponent);
		}
		
		
		removeSlotPanel = new JPanel();
		add(removeSlotPanel, BorderLayout.SOUTH);
		JPanel myContainer = new JPanel();
		
		 myContainer.setLayout(new BoxLayout(myContainer,BoxLayout.Y_AXIS));
		  
		 JPanel slotID = new JPanel();
		 slotID.setLayout(new GridLayout(0,2));
		 myContainer.add(slotID);
		 
		 JLabel slotLabel = new JLabel("Enter Slot Number:");
		 slotID.add(slotLabel);
		  
		 JTextField regoField = new JTextField();
		 slotID.add(regoField);
		 JButton removeButton = new JButton("Remove Slot");
		 removeButton.addActionListener(e->{
			 ParkingSlot slot = carPark1.findSlot(regoField.getText());
			 
			 if(slot != null) {
				 if(slot.getCars() == null && slot.isStaff() == true) {
					 carPark1.removeSlot(slot);
					 JButton removeSlotButton = buttonMap.get(slot.getSlotID());
					 buttonMap.remove(slot.getSlotID(),removeSlotButton);
					 panelForSlots.remove(removeSlotButton);
					 revalidate();
					 repaint();
					 
				 }
				 else if(slot.getCars() == null && slot.isStaff() == false) {
					 carPark1.removeSlot(slot);
					 JButton removeSlotButton = buttonMap.get(slot.getSlotID());
					 buttonMap.remove(slot.getSlotID(),removeSlotButton);
					 panelForVisitorSlots.remove(removeSlotButton);
					 revalidate();
					 repaint();
					 }
				 else {
					 JOptionPane.showMessageDialog(this, "Slot Currently Occupied");
				 }
			}else {
				JOptionPane.showMessageDialog(this, "Slot Does Not Exist");
				
			}
			 
		 });
		 
		 myContainer.add(removeButton);
			
		 removeSlotPanel.add(myContainer);
		
		 revalidate();
		
		
	}
	
	/**
	 * method to create a component that allows the user to add additional parking slots after it is initially created when program begins 
	 */
	public void componentToAddSlot() {
		
		if(p != null) {
			remove(p);
		}
		
		if(x != null) {
			remove(x);
		}
		
		if(findCarPanel != null) {
			remove(findCarPanel);
		}
		
		if(removeSlotPanel !=null) {
			remove(removeSlotPanel);
		}
			
		
		addSlotComponent =  new JPanel();
		  
		  add(addSlotComponent, BorderLayout.SOUTH);
		
		  JPanel myContainer = new JPanel();
		
		  myContainer.setLayout(new BoxLayout(myContainer,BoxLayout.Y_AXIS));
		  
		  
		 
		  JPanel slotID = new JPanel();
		  slotID.setLayout(new GridLayout(0,2));
		  JLabel slotLabel = new JLabel("Enter Slot ID:");
		  slotID.add(slotLabel);
		  JTextField slotTextField = new JTextField();
		  slotID.add(slotTextField);
		  
		  JRadioButton isStaff = new JRadioButton("Staff");
		  JRadioButton isVisitor = new JRadioButton("Visitor");
		  ButtonGroup group = new ButtonGroup();
		 
		  group.add(isStaff);
		  group.add(isVisitor);
		  
		  slotID.add(isVisitor);
		  slotID.add(isStaff);
		  
		  myContainer.add(slotID);
		  

		  String regEx = "[A-Z][0-9][0-9]";
		  
		  JButton addButton = new JButton("Add");
		  myContainer.add(addButton);
		  
		  addButton.addActionListener(e->{
			  ParkingSlot p = carPark1.findSlot(slotTextField.getText());
			  if(p == null) {
				  if(slotTextField.getText().matches(regEx) && isStaff.isSelected()) {
					  String slotId = slotTextField.getText();
					  carPark1.addSlotsinCarPark(new ParkingSlot(slotId,true));
					  JButton button = new JButton(slotId + ": Empty");
					 
					  buttonMap.put(slotId, button);

					  panelForSlots.add(button);
					  repaint();
					  revalidate();
					  
					  
				  }
				  else if(slotTextField.getText().matches(regEx) && isVisitor.isSelected()) {
					  String slotId = slotTextField.getText();
					  carPark1.addSlotsinCarPark(new ParkingSlot(slotId,false));
					  JButton button = new JButton(slotId + ": Empty");
					
						
					  buttonMap.put(slotId, button);
					  
					  panelForVisitorSlots.add(button);
					  repaint();
					  revalidate();
				  }
				  else {
					  JOptionPane.showMessageDialog(this,"Please Match The Pattern For Slot ID, Ex \"D12\"");
				  }
			  }else {
				  JOptionPane.showMessageDialog(this, "This Slot ID is already Taken, Please Enter a Different ID");
			  }
		  });
		  
		  addSlotComponent.add(myContainer);
		  revalidate();

		
		
	}
	
	/**
	 * method that generates a dialog box which allows the user to interactively add a car and remove an empty slot 
	 * @param buttonString a String object which maps to a JButton object and manipulates the list based on user input 
	 */
	public void interActiveAddCar(String buttonString) {
		String[] buttons = { "Add Car", "Remove Slot"};

	    int rc = JOptionPane.showOptionDialog(this, "What Would You Like to Do?", "Confirmation",
	        JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, buttons,buttons[1]);
	    
	    ParkingSlot p = carPark1.findSlot(buttonString);
	    if(rc == 1 && p.getCars() == null) {
	    	if(p.isStaff() == true) {
	    		carPark1.removeSlot(p);
		    	JButton xx = buttonMap.get(buttonString);
		    	buttonMap.remove(p.getSlotID(),xx);
				panelForSlots.remove(xx);
				repaint();
				revalidate();
	    	}
	    	else if(p.isStaff() == false) {
	    		carPark1.removeSlot(p);
		    	JButton xx = buttonMap.get(buttonString);
		    	buttonMap.remove(p.getSlotID(),xx);
				panelForVisitorSlots.remove(xx);
				repaint();
				revalidate();
	    	}
	    	
	    }
	    
	   if(rc == 0 & p.isEmpty() == false) {
	    	interactiveAddCarInSlot(buttonString);
	    	
	    }else {
	    	JOptionPane.showMessageDialog(this, "Slot Occupied");
	    }
	   
	   
	  

	}
	
	/**
	 * a method to add car to empty slots dynamically 
	 * @param btn a String object which maps to a JButton object and manipulates the list based on user input 
	 */
	public void interactiveAddCarInSlot(String btn) {
		String[] buttons = { "Yes", "No"};
		
	    int rc = JOptionPane.showOptionDialog(this, "Is This Person Staff?", "Confirmation",
	        JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, buttons,buttons[0]);
		String regEx = "[A-Z][0-9][0-9][0-9][0-9]";
		
		ParkingSlot p = carPark1.findSlot(btn);
		
		if(rc == 0 && p.isStaff() == true) {
			String carRego = JOptionPane.showInputDialog("Enter Car Registration");
			if(carRego.matches(regEx) && carPark1.findCar(carRego) == null) {
				String ownerName = JOptionPane.showInputDialog("Enter Name");
				JButton addBtn = buttonMap.get(btn);
				 addBtn.setText(p.getSlotID()+"\r" + "Occupied by "+ ownerName + "\r" + "Rego :" + carRego);
				  buttonMap.replace(btn,addBtn);
				  p.addCar(new Car(carRego,ownerName));
				  addBtn.setForeground(Color.red);
				  addBtn.revalidate();
				  addBtn.repaint();
			}
			else {
				JOptionPane.showMessageDialog(this, "Duplicate Car Registration or match Entry,Ex \"T1234\" ");
			}
			
		}else if(rc == 1 && p.isStaff() == false ) {
			String carRego = JOptionPane.showInputDialog("Enter Car Registration");
			if(carRego.matches(regEx) && carPark1.findCar(carRego) == null) {
				String ownerName = JOptionPane.showInputDialog("Enter Name");
				JButton addBtn = buttonMap.get(btn);
				addBtn.setText(p.getSlotID()+"\r" + "Occupied by "+ ownerName + "\r" + "Rego :" + carRego);
				buttonMap.replace(btn,addBtn);
				p.addCar(new Car(carRego,ownerName));
				addBtn.setForeground(Color.red);
				addBtn.revalidate();
				addBtn.repaint();
			}else {
				JOptionPane.showMessageDialog(this, "Duplicate Car Registration or match Entry,Ex \"T1234\" ");
			}
		}
		
		else {
			JOptionPane.showMessageDialog(this,"Choose the Correct Slot");
		}
		
	}
	
	
}
