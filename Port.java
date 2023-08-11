package mariTime_Industry;

import java.util.ArrayList;

public class Port {
	private String portName;
	private ArrayList<Ship> dockedShips = new ArrayList<Ship>(); 
	private ArrayList<Container> containersOnPort = new ArrayList<Container>();
	
	public Port() {
		
	}
	
	public Port(String portName) {
		super();
		this.portName = portName;
	}
	
	public Port(String portName, ArrayList<Ship> dockedShips) {
		super();
		this.portName = portName;
		this.dockedShips = dockedShips;
	}

	public String getPortName() {
		return portName;
	}
	
	public void setPortName(String portName) {
		this.portName = portName;
	}
	
	public ArrayList<Ship> getDockedShips() {
		return dockedShips;
	}
	
	public void setDockedShips(Ship newShips) {
		this.dockedShips.add(newShips);
	}

	public ArrayList<Container> getContainersOnPort() {
		return containersOnPort;
	}

	public void setContainersOnPort(ArrayList<Container> containersOnPort) {
		this.containersOnPort = containersOnPort;
	}
	
	public static void addNewPort(ArrayList<Port> registeredPorts, String portName) {
		Port tempObj = new Port(portName);
		registeredPorts.add(tempObj);
	}
	
	public static void displayPorts(ArrayList<Port> registeredPorts) {
		for(int i=0;i<registeredPorts.size();i++) {
			System.out.println(i + " -> " + registeredPorts.get(i).getPortName());
		}
	}
	public static void displayContainerOnPort(int selectedPort, ArrayList<Port> registeredPorts) {
		ArrayList<Container> containersOnPort = registeredPorts.get(selectedPort).getContainersOnPort();
		System.out.println("===============================================================");
		for(Container c:containersOnPort) {
			System.out.println(" --------------------------- ");
			System.out.println("Conatiner ID : "+c.containerId+"\nContainer Type : "+c.containerType);
			System.out.println(" --------------------------- ");
		}
		System.out.println("===============================================================");
		System.out.println("Total no of containers "+containersOnPort.size());
		System.out.println("===============================================================");
		
	}
	
	public static void addNewShipToPort(ArrayList<Port> registeredPorts, int selectedPort, String shipName) {
		Ship tempObj = new Ship(shipName, "empty", null);
		registeredPorts.get(selectedPort).setDockedShips(tempObj);
	}
	
	public static void displayShipsOnPort(int selectedPort, ArrayList<Port> registeredPorts) {
		ArrayList<Ship> dockedShips = registeredPorts.get(selectedPort).getDockedShips();
		for(Ship s:dockedShips) {
			System.out.println(" --------------------------- ");
			System.out.println("Name : " + s.getShipName() +"\nStatus : "+ s.getShipStatus());
			if(s.getShipStatus() == "empty") {
				System.out.println("No of Container : 0");
			}
		}
	}
	
	public ArrayList<Integer> selectContainersToShip(int selectedPort, ArrayList<Port> registeredPorts, String[] selectedContainers) {
		ArrayList<Integer> selectedContainersToShip = new ArrayList<Integer>();
		
		for(int i=0;i<selectedContainers.length;i++) {
			selectedContainersToShip.add(Integer.parseInt(selectedContainers[i]));
		}
		return selectedContainersToShip;
	}
	
	public void displayDestinationPorts(int selectedPort, ArrayList<Port> registeredPorts) {
		System.out.println("Select the Destination : ");
		int i = 0;
		for(Port e: registeredPorts) {
			if(e == registeredPorts.get(selectedPort)) {
				i++;
				continue;
			}else {
				System.out.println(i++ +" -> "+ e.getPortName());
			}
		}
	}
	
	public int searchAnEmptyShip() {
		int ii = 0;
		for(Ship s:dockedShips) {
			if(s.getShipStatus() == "empty") {
				break;
			}
			ii++;
		}
		if(ii == dockedShips.size()) {
			return -1;
		}
		return ii;
	}
}
