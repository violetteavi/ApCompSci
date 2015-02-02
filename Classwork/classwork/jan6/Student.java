package jan6;

public class Student {

	private String firstName;
	private char middleInitial;
	private String lastName;
	
	public static boolean equals(Student s1, Student s2) {
		return s1.getFirstName().equals(s2.getFirstName())
				&& s1.getLastName().equals(s2.getLastName())
				&& s1.getMiddleInitial()==s2.getMiddleInitial();
	}
	
	public boolean equals(Student other) {
		return equals(this, other);
	}
	
	//getters and setters
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public char getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(char middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
