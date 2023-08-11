package mariTime_Industry;

import java.util.ArrayList;

public class Ship {
	private String shipName;
	private String shipStatus;
	private static int shipCapacity = 150;
	private ArrayList<Container> loadedContainerOnShip = new ArrayList<Container>();
	double RevenueOfTheTrip;
	
	public Ship(String shipName, String shipStatus, ArrayList<Container> loadOfContainerOnShip) {
		super();
		this.shipName = shipName;
		this.shipStatus = shipStatus;
		this.loadedContainerOnShip = loadOfContainerOnShip;
	}
	
	public String getShipName() {
		return shipName;
	}
	
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	
	public String getShipStatus() {
		return shipStatus;
	}
	
	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}

	public ArrayList<Container> getLoadedContainerOnShip() {
		return loadedContainerOnShip;
	}

	public void setLoadedContainerOnShip(ArrayList<Container> loadedOfContainerOnShip) {
		this.loadedContainerOnShip = loadedOfContainerOnShip;
	}
	
	public void emptyTheShip() {
		this.loadedContainerOnShip.clear();
	}

	public static int getShipCapacity() {
		return shipCapacity;
	}

	public static void setShipCapacity(int shipCapacity) {
		Ship.shipCapacity = shipCapacity;
	}

}
