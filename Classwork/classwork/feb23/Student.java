package feb23;

import java.util.ArrayList;

public class Student {

	private String firstName;
	private String lastName;
	private double gpa;
	
	public static String highestGPA(ArrayList<Student> students) {
		if(students.size()==0) {
			return null;
		}
		int maxIndex = 0;
		double maxGPA = students.get(0).getGpa();
		for(int i = 1; i < students.size(); i++) {
			if(maxGPA < students.get(i).getGpa()) {
				maxIndex = i;
				maxGPA = students.get(i).getGpa();
			}
		}
		return students.get(maxIndex).getFullName();
	}
	
	public static void sortByLastName(ArrayList<Student> students) {
		for(int i = 0; i < students.size(); i++) {
			int relMinIndex = i;
			String relMinName = students.get(i).getLastName();
			for(int j = i + 1; j < students.size(); j++) {
				String compName = students.get(j).getLastName();
				if(relMinName.compareTo(compName) > 0) {
					relMinIndex = j;
					relMinName = compName;
				}
			}
			swap(i, relMinIndex, students);
		}
	}

	private static void swap(int ind1, int ind2, ArrayList<Student> students) {
		Student temp = students.get(ind1);
		students.set(ind1, students.get(ind2));
		students.set(ind2, temp);
	}
	
	//@Precondition: sorted by last name, ascending order
	public static Student getStudent(String lastName, ArrayList<Student> students) {
		int imin = 0;
		int imax = students.size() - 1;
		while(imin <= imax) {
			int imid = midPoint(imin, imax);
			Student midStudent = students.get(imid);
			String midLastName = midStudent.getLastName();
			if(midLastName.equals(lastName)) {
				return midStudent;
			} else if(midLastName.compareTo(lastName) < 0) {
				imin = imid + 1;
			} else {
				imax = imid - 1;
			}
		}
		return null;
	}

	private static int midPoint(int imin, int imax) {
		return (imin + imax) / 2;
	}

	
	
	public Student(String firstName, String lastName, double gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gpa = gpa;
	}
	
	public String getFullName() {
		return lastName + ", " + firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public double getGpa() {
		return gpa;
	}
	
}
