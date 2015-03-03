package feb23;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {

	ArrayList<Student> base;
	ArrayList<Student> duplicates;
	
	@Before
	public void init() {
		base = new ArrayList<Student>();
		base.add(new Student("Bob", "Dylan", 3.6));
		base.add(new Student("Jane", "Doe", 3.2));
		base.add(new Student("Jack", "Reichert", 2.6));
		base.add(new Student("Mylan", "Somerset", 4.0));
	}
	
	@Test
	public void highestGPABaseTest() {
		assertTrue(Student.highestGPA(base).equals("Somerset, Mylan"));
	}
	
	@Test
	public void sortByLastNameTest() {
		Student.sortByLastName(base);
		assertTrue(base.get(0).getFullName().equals("Doe, Jane"));
		assertTrue(base.get(3).getFullName().equals("Somerset, Mylan"));
//		for(int i = 0; i < base.size(); i++) {
//			System.out.println(base.get(i).getFullName());
//		}
	}
	
	@Test
	public void findStudent() {
		Student.sortByLastName(base);
		assertTrue(base.get(1)==Student.getStudent("Dylan", base));
	}
}
