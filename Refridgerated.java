package mariTime_Industry;

public class Refridgerated extends Container{

	public int getContainerId() {
		return this.containerId;
	}
	
	public void setContainerId(int containerId) {
		this.containerId = containerId;
	}
	
	public String getContainerType() {
		return this.containerType;
	}
	
	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}
	
	public int getContainerCapacity() {
		return this.containerCapacity;
	}

	public Refridgerated(String containerType, int containerId) {
		this.containerId = containerId;
		this.setContainerType(containerType);
		this.containerCapacity = 20;
	}

}
