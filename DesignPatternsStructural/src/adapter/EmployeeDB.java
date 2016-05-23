package adapter;

public class EmployeeDB implements Employee {

	private String id;
	private String firstName;
	private String lastName;
	private String email;
	
	public EmployeeDB(String id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getEmail() {
		return email;
	}
	
	public String toString() {
		return "ID: " + getId() + ", First Name: " + getFirstName() + ", Last Name: " + getLastName() + ", Email: " + getEmail();
	}

}
