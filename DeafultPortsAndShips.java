package mariTime_Industry;

import java.util.ArrayList;

public class DeafultPortsAndShips {
	

	void addDeafultPortsAndShips(ArrayList<Port> registeredPorts) {
		
//		Vizag's port and its default ships
		
		Ship tempS1 = new Ship("Titanic", "empty" , null);
		Ship tempS2 = new Ship("Victory", "empty" , null);
		Ship tempS3 = new Ship("May Flower", "empty" , null);
		ArrayList<Ship> dockedShips = new ArrayList<Ship>();
		dockedShips.add(tempS1);
		dockedShips.add(tempS2);
		dockedShips.add(tempS3);
		Port temp = new Port("Vizag", dockedShips);
		ArrayList<Container> containersOnPort = new ArrayList<Container>();
		Container tempC1 = new Basic("basic", 0);
		Container tempC2 = new Basic("basic", 1);
		Container tempC3 = new Heavy("heavy", 2);
		Container tempC4 = new Liquid("liquid", 3);
		Container tempC5 = new Refridgerated("refridgerated", 4);
		Container tempC6 = new Refridgerated("refridgerated", 5);
		Container tempC7 = new Heavy("heavy", 6);
		Container tempC8 = new Heavy("heavy", 7);
		Container tempC9 = new Heavy("heavy", 8);
		Container tempC10 = new Liquid("liquid", 9);
		Container tempC11 = new Refridgerated("refridgerated", 10);
		Container tempC12 = new Refridgerated("refridgerated", 11);
		Container tempC13 = new Liquid("liquid", 12);
		Container tempC14 = new Heavy("heavy", 13);
		Container tempC15 = new Heavy("heavy", 14);
		containersOnPort.add(tempC1);
		containersOnPort.add(tempC2);
		containersOnPort.add(tempC3);
		containersOnPort.add(tempC4);
		containersOnPort.add(tempC5);
		containersOnPort.add(tempC6);
		containersOnPort.add(tempC7);
		containersOnPort.add(tempC8);
		containersOnPort.add(tempC9);
		containersOnPort.add(tempC10);
		containersOnPort.add(tempC11);
		containersOnPort.add(tempC12);
		containersOnPort.add(tempC13);
		containersOnPort.add(tempC14);
		containersOnPort.add(tempC15);
		registeredPorts.add(temp);
		registeredPorts.get(0).setContainersOnPort(containersOnPort);
		
//		Chennai's port and its default ships
		
		tempS1 = new Ship("Golden hind", "empty" , null);
		tempS2 = new Ship("The Queen Mary", "empty" , null);
		tempS3 = new Ship("Santa Maria", "empty" , null);
		dockedShips = new ArrayList<Ship>();
		dockedShips.add(tempS1);
		dockedShips.add(tempS2);
		dockedShips.add(tempS3);
		temp = new Port("Chennai", dockedShips);
		containersOnPort = new ArrayList<Container>();
		tempC1 = new Basic("basic", 100);
		tempC2 = new Liquid("liquid", 101);
		tempC3 = new Heavy("heavy", 102);
		tempC4 = new Heavy("heavy", 103);
		tempC5 = new Heavy("heavy", 104);
		tempC6 = new Heavy("heavy", 105);
		tempC7 = new Heavy("heavy", 106);
		tempC8 = new Liquid("liquid", 107);
		tempC9 = new Liquid("liquid", 108);
		tempC10 = new Liquid("liquid", 109);
		tempC11 = new Refridgerated("refridgerated", 110);
		tempC12 = new Refridgerated("refridgerated", 111);
		tempC13 = new Liquid("liquid", 112);
		tempC14 = new Heavy("heavy", 113);
		tempC15 = new Heavy("heavy", 114);
		containersOnPort.add(tempC1);
		containersOnPort.add(tempC2);
		containersOnPort.add(tempC3);
		containersOnPort.add(tempC4);
		containersOnPort.add(tempC5);
		containersOnPort.add(tempC6);
		containersOnPort.add(tempC7);
		containersOnPort.add(tempC8);
		containersOnPort.add(tempC9);
		containersOnPort.add(tempC10);
		containersOnPort.add(tempC11);
		containersOnPort.add(tempC12);
		containersOnPort.add(tempC13);
		containersOnPort.add(tempC14);
		containersOnPort.add(tempC15);
		
		registeredPorts.add(temp);
		registeredPorts.get(1).setContainersOnPort(containersOnPort);
		
//		Mumbai's port and its default ships
		
		tempS1 = new Ship("Flying Dutchman", "empty" , null);
		tempS2 = new Ship("Galleon", "empty" , null);
		tempS3 = new Ship("Black Pearl", "empty" , null);
		dockedShips = new ArrayList<Ship>();
		dockedShips.add(tempS1);
		dockedShips.add(tempS2);
		dockedShips.add(tempS3);
		temp = new Port("Mumbai", dockedShips);
		containersOnPort = new ArrayList<Container>();
		tempC1 = new Basic("basic", 200);
		tempC2 = new Heavy("heavy", 201);
		tempC3 = new Heavy("heavy", 202);
		tempC4 = new Liquid("liquid", 203);
		tempC5 = new Liquid("liquid", 204);
		tempC6 = new Refridgerated("refridgerated", 205);
		tempC7 = new Basic("basic", 206);
		tempC8 = new Liquid("liquid", 207);
		tempC9 = new Liquid("liquid", 208);
		tempC10 = new Liquid("liquid", 209);
		tempC11 = new Refridgerated("refridgerated", 210);
		tempC12 = new Refridgerated("refridgerated", 211);
		containersOnPort.add(tempC1);
		containersOnPort.add(tempC2);
		containersOnPort.add(tempC3);
		containersOnPort.add(tempC4);
		containersOnPort.add(tempC5);
		containersOnPort.add(tempC6);
		containersOnPort.add(tempC7);
		containersOnPort.add(tempC8);
		containersOnPort.add(tempC9);
		containersOnPort.add(tempC10);
		containersOnPort.add(tempC11);
		containersOnPort.add(tempC12);
		registeredPorts.add(temp);
		registeredPorts.get(2).setContainersOnPort(containersOnPort);
		
	}
}
