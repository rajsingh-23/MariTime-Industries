package mariTime_Industry;

import java.util.ArrayList;

public interface ContainerOperations {
	void addContainer(int selectedPort, ArrayList<Port> registeredPorts, int selectedContainerCount, int selectedType, 
			ArrayList<Container> containerOnPort);
}
