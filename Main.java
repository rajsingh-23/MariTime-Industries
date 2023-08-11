package mariTime_Industry;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	
	static Scanner scanner = new Scanner(System.in);
//************************************************************************************
//	log-in screen for trading
//************************************************************************************
	
	public static int logIn(ArrayList<Port> registeredPorts) {
		System.out.println("\n*** Welcome to MariTime Industries ***");
		System.out.println(" ");
		System.out.println("Select the location for trading...");
		Port.displayPorts(registeredPorts);
		System.out.println("101 -> Register a Port \n404 -> Exit!");
		int selectedPort = scanner.nextInt();
		System.out.println("===============================================================");
		return selectedPort;
	}
	
//************************************************************************************
//	selecting the type of trading
//************************************************************************************
	
	private static void tradingType(int selectedPort, ArrayList<Port> registeredPorts) throws InterruptedException {
		System.out.println("===============================================================");
		System.out.println("Register a Ship -> 0\nShip a Cargo -> 1\nLook for a Ship -> 2\nLook for Containers On Port -> 3\nAdd new Containers to Port -> 4\nExit -> 404");
		int selectedTradingType = scanner.nextInt();
		switch(selectedTradingType) {
		case 0: registerAShip(registeredPorts, selectedPort);
		break;
		case 1: shipACargo(selectedPort,registeredPorts);
		break;
		case 2: lookForAShip(selectedPort, registeredPorts);
		break;
		case 3: lookForContainerOnPort(selectedPort, registeredPorts);
		break;
		case 4: addNewContainersToPort(selectedPort, registeredPorts);
		break;
		case 404: logIn(registeredPorts);
			break;
		default :
			System.out.println("Enter the correct input Please...");
		}
		System.out.println("===============================================================");
	}
	
//************************************************************************************
//	getting data for new containers to add
//************************************************************************************
	
	private static void addNewContainersToPort(int selectedPort, ArrayList<Port> registeredPorts) {
		ArrayList<Container> containerOnPort = registeredPorts.get(selectedPort).getContainersOnPort();
		while(true) {
			System.out.println("====================================================================");
		System.out.println("Select a type of containers to add to the port :");
		System.out.println("1 -> Basic\n2 -> Heavy\n3 -> Liquid\n4 -> Refridgerated\n101 -> Exit!");
		int selectedType = scanner.nextInt();
		if(selectedType == 101) {
			break;
		}
		System.out.println("How many containers of the selected Type ?");
		int selectedContainerCount = scanner.nextInt();
		Container obj = new Container();
		obj.addContainer(selectedPort, registeredPorts, selectedContainerCount, selectedType, containerOnPort);
		}

	}
	
//************************************************************************************
//	looking for the current containers present on the port
//************************************************************************************

	private static void lookForContainerOnPort(int selectedPort, ArrayList<Port> registeredPorts) {
		Port.displayContainerOnPort(selectedPort, registeredPorts);
	}
	
//************************************************************************************
//	shipping a cargo from one location to other
//************************************************************************************

	private static void shipACargo(int selectedPort, ArrayList<Port> registeredPorts) throws InterruptedException {

		registeredPorts.get(selectedPort).displayDestinationPorts(selectedPort, registeredPorts);
		int selectedDestinationPort = scanner.nextInt();
		
//		getting the containers to be ships to the destination
//************************************************************************************
		
		ArrayList<Integer> selectedContainersId = selectContainersToShip(selectedPort, registeredPorts);
		

//		search an empty ship to dock and ship the cargo to the destination
//************************************************************************************
		while(selectedContainersId.size() != 0) {
//			this below function will search and return a empty ship to load
			int emptyShipStatus = registeredPorts.get(selectedPort).searchAnEmptyShip();
//		validating the above functions output
			if(emptyShipStatus == -1) {
				System.out.println("No ships are available currently please be patient.....\n We are looking into it!");
				break;
			}else {
				System.out.println("\n**** An Empty ship found.****\n");
			}
			
			ArrayList<Ship> dockedShips = registeredPorts.get(selectedPort).getDockedShips();
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(registeredPorts.get(selectedPort).getPortName() + " | P |<|__S__|>                                                  | P |"+registeredPorts.get(selectedDestinationPort).getPortName()+" [ Current status: Loading the ship " + dockedShips.get(emptyShipStatus).getShipName()+" ]");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			dockedShips.get(emptyShipStatus).setShipStatus("loaded");
			Thread.sleep(3000);
			System.out.println(registeredPorts.get(selectedPort).getPortName()+" | P |<|00S00|>                                                  | P |"+registeredPorts.get(selectedDestinationPort).getPortName()+" [ current status : Ship loaded. ]");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			Thread.sleep(3000);
			ArrayList<Container> containersToRemoveFromPort = new ArrayList<Container>();
			ArrayList<Integer> selectedContainerIdsToRemove = new ArrayList<Integer>();
			ArrayList<Container> loadContainersToShip = new ArrayList<Container>(); 
			ArrayList<Container> containerOnPort = registeredPorts.get(selectedPort).getContainersOnPort();
			double revenueForATrip = registeredPorts.get(selectedPort).getDockedShips().get(emptyShipStatus).RevenueOfTheTrip; 
			int shipLoadCapacity = Ship.getShipCapacity();
			boolean shipFullFlag = false;
			for(Container c:containerOnPort) {
				for(int id:selectedContainersId) {
					if(c.containerId == id) {
						if(c.containerCapacity <= shipLoadCapacity) {
							loadContainersToShip.add(c);
							containersToRemoveFromPort.add(c);
							selectedContainerIdsToRemove.add(id);
							shipLoadCapacity = shipLoadCapacity - c.containerCapacity;
							switch(c.containerType) {
							case "basic": revenueForATrip+=10000;
								break;
							case "heavy": revenueForATrip+=20000;
								break;
							case "liquid": revenueForATrip+=7500;
								break;
							case "refridgerated": revenueForATrip+=15000;
								break;
							}
							
						}else {
							shipFullFlag = true;
						}
					}
					if(shipFullFlag == true) {
						break;
					}
				}
				
				if(shipFullFlag == true) {
					break;
				}
			}
		
		

//		loading process started

//		processing to load the ship
//************************************************************************************
		
		

//		removing container from port
//************************************************************************************
		
		for(Container c:containersToRemoveFromPort) {
			containerOnPort.remove(c);
		}
		for(Integer i:selectedContainerIdsToRemove) {
			selectedContainersId.remove(i);
		}
		
		
//		remove from the selected containers list
		if(selectedContainersId.size()>0) {
			System.out.println("\n*****---------------------------------------------------------------------------------------------------------------*****");
			
			System.out.println("The current ship has only "+shipLoadCapacity+" tones left in it's capacity, so rest of the container's will be loaded in the next Ship...");
			
			System.out.println("\n*****---------------------------------------------------------------------------------------------------------------*****");
		}
		

//		un-docking the ship
//************************************************************************************
		dockedShips.get(emptyShipStatus).setLoadedContainerOnShip(loadContainersToShip);
		System.out.println(registeredPorts.get(selectedPort).getPortName()+" | P |  ...<|00S00|>                                             | P |"+registeredPorts.get(selectedDestinationPort).getPortName()+" [ Undocking the ship : " + dockedShips.get(emptyShipStatus).getShipName() +" container on Ship : "+dockedShips.get(emptyShipStatus).getLoadedContainerOnShip().size()+" ]");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		Thread.sleep(3000);

//		Un-dock the loaded ship for destination
//************************************************************************************
		
		Ship removedShip = dockedShips.get(emptyShipStatus);
		dockedShips.remove(emptyShipStatus);
		ArrayList<Ship> destinationDockedShips = registeredPorts.get(selectedDestinationPort).getDockedShips();
		destinationDockedShips.add(removedShip);
		
		System.out.println(registeredPorts.get(selectedPort).getPortName()+" | P |                     ...<|00S00|>                          | P |"+registeredPorts.get(selectedDestinationPort).getPortName());
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		Thread.sleep(3000);
		//reached the destination

//		ship reached its destination now processing for docking it for unloading the ship verification process
//*************************************************************************************************************
		
		for(Ship e:destinationDockedShips) {
			if(removedShip.getShipName() == e.getShipName()) {
//				Confirmation that ship has reached the destination port
				System.out.println(registeredPorts.get(selectedPort).getPortName()+" | P |                                             ...<|00S00|>  | P |"+ registeredPorts.get(selectedDestinationPort).getPortName()+" [ Ship " + e.getShipName() +" has reached the destination port : "+ registeredPorts.get(selectedDestinationPort).getPortName()+" ]");
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				Thread.sleep(3000);
				System.out.println(registeredPorts.get(selectedPort).getPortName()+" | P |                                                  <|00S00|>| P |"+registeredPorts.get(selectedDestinationPort).getPortName()+" [ Docking the ship : " + e.getShipName() +" No of container on Ship : "+ e.getLoadedContainerOnShip().size()+" ]");
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				Thread.sleep(3000);
				System.out.println(registeredPorts.get(selectedPort).getPortName()+" | P |                                                  <|0_S0_|>| P |"+registeredPorts.get(selectedDestinationPort).getPortName()+" [ Unloading the ship.... ]");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				Thread.sleep(3000);
	
//				unloading the loaded containers on the ship to the port
//*************************************************************************************************************
				ArrayList<Container> containerOnDestinationPort = registeredPorts.get(selectedDestinationPort).getContainersOnPort();
				for(Container c:loadContainersToShip) {
					containerOnDestinationPort.add(c);
				}
				
//				making the ship empty
				e.emptyTheShip();
				System.out.println(registeredPorts.get(selectedPort).getPortName()+" | P |                                                  <|__S__|>| P |"+registeredPorts.get(selectedDestinationPort).getPortName()+" [ Current status : Ship "+e.getShipName()+" unloaded ]");
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				e.setShipStatus("empty");
				Thread.sleep(3000);
				System.out.println("\n*** Current status *** \nUnloaded the ship : " + e.getShipName() +" \nShip Status : "+ e.getShipStatus()+" \nNo of container on Ship : "+ e.getLoadedContainerOnShip().size());
				System.out.println("Total revenue from this trip for the ship "+e.getShipName()+" is : $ "+revenueForATrip+"\n");
				System.out.println("===========================================================================================================================");
			}
		}
		}
	}
	
//************************************************************************************
//	getting the containers to be ships to the destination
//************************************************************************************
	
	private static ArrayList<Integer> selectContainersToShip(int selectedPort, ArrayList<Port> registeredPorts) {
		
		System.out.println("How many container do you want to ship ? ");
		int noOfContainersToShip = scanner.nextInt();
		Port.displayContainerOnPort(selectedPort, registeredPorts);
		System.out.println("Enter the "+noOfContainersToShip+" container id's to ship : ");
		String s = scanner.next();
		String[] selectedContainers = s.split(",");
		ArrayList<Integer> selectedContainersToShip = new ArrayList<Integer>();
		selectedContainersToShip = registeredPorts.get(selectedPort).selectContainersToShip(selectedPort, registeredPorts, selectedContainers);
		return selectedContainersToShip;
			
	}

//************************************************************************************
//	looking for the ships on the current port
//************************************************************************************
	
	private static void lookForAShip(int selectedPort, ArrayList<Port> registeredPorts) {
		
		System.out.println("===============================================================");
		Port.displayShipsOnPort(selectedPort, registeredPorts);
		System.out.println("===============================================================");
		System.out.println("Total no of ships "+registeredPorts.get(selectedPort).getDockedShips().size());
		
	}

	
//************************************************************************************
//	registering a ship on an particular port
//************************************************************************************
	
	private static void registerAShip(ArrayList<Port> registeredPorts, int selectedPort) {
		System.out.println("===============================================================");
		System.out.print("Enter the Ship Name : ");
		String shipName = scanner.next();
		Port.addNewShipToPort(registeredPorts, selectedPort, shipName);
		System.out.println("Ship " + shipName + " is Successfully registered.");
		System.out.println("===============================================================");
	}
	
//************************************************************************************
//	registering a new port
//************************************************************************************
	
	private static void registerAPort(ArrayList<Port> registeredPorts) {
		System.out.println("===============================================================");
		System.out.print("Enter the Port Name : ");
		String portName = scanner.next();
		Port.addNewPort(registeredPorts, portName);
		System.out.println("Port " + portName + " is Sucessfully registered.");
		System.out.println("===============================================================");
	}
	
//============================= Main===============================================================
//	this is the main method
	
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Port> registeredPorts = new ArrayList<Port>();
		defaultPortsAndShips(registeredPorts);
		while(true) {
			int selectedPort = logIn(registeredPorts);
			if(selectedPort == 101) {
				registerAPort(registeredPorts);
				selectedPort = 0;
				logIn(registeredPorts);
			}
			if(selectedPort == 404) {
				break;
			}
			tradingType(selectedPort, registeredPorts);
		}
		System.out.println(" ");
		System.out.println("*** Thanks for using MariTime Industries... ****");
	}
	
//============================ Defaults Ports and Ships=======================================================================
//	adding default ports and ships to the virtual world
	
	private static void defaultPortsAndShips(ArrayList<Port> registeredPorts) {
		
		DeafultPortsAndShips temp = new DeafultPortsAndShips();
		temp.addDeafultPortsAndShips(registeredPorts);
		
	}

}
