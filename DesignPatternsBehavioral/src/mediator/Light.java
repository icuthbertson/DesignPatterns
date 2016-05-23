package mediator;

//receiver
public class Light {

	private boolean isOn = false;
	
	private String location = "";
	
	public Light() {
		
	}
	
	public Light(String location) {
		this.location = location;
	}
	
	public boolean isOn() {
		return isOn;
	}
	
	public void toggle() {
		if(isOn) {
			isOn = false;
			System.out.println(location + " Light switched off.");
		}
		else {
			isOn = true;
			System.out.println(location + " Light switched on.");
		}
	}
	
}
