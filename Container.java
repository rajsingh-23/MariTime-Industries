package mariTime_Industry;

import java.util.ArrayList;

class Container implements ContainerOperations {
	
	String containerType;
	int containerId;
	int containerCapacity;

	@Override
	public void addContainer(int selectedPort, ArrayList<Port> registeredPorts,int selectedContainerCount,int selectedType,ArrayList<Container> containerOnPort) {

		for(int i=0;i<selectedContainerCount;i++) {
			switch(selectedType) {
			case 1:
				Basic temp = new Basic("basic", containerOnPort.size()+1);
				containerOnPort.add(temp);
				break;
			case 2:
				Heavy temp1 = new Heavy("heavy", containerOnPort.size()+1);
				containerOnPort.add(temp1);
				break;
			case 3:
				Liquid temp2 = new Liquid("liquid", containerOnPort.size()+1);
				containerOnPort.add(temp2);
				break;
			case 4:
				Refridgerated temp3 = new Refridgerated("refridgerated", containerOnPort.size()+1);
				containerOnPort.add(temp3);
				break;
			}
		}
		
	}
	
}
