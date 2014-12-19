package fileio;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import calcproject.MathCalc;

public class UtilityTest {

	@Test
	public void testRead() {
		String[][] recieved = null;
		try {
			recieved = Utility.read("C:\\Users\\family\\Documents\\Andrew's Stories\\Programming Comp 12-13\\Dec2013-Packet\\studentdata\\bad.dat");
		} catch (IOException e) {
			fail();
		}
		String[][] expected = new String[5][2];
		expected[0][0] = "Brian";
		expected[0][1] = "Cranston";
		expected[1][0] = "Aaron";
		expected[1][1] = "Paul";
		expected[2][0] = "RJ";
		expected[2][1] = "Mitte";
		expected[3][0] = "Anna";
		expected[3][1] = "Gunn";
		expected[4][0] = "Dean";
		expected[4][1] = "Morris";
		assertTrue(Utility.isEqual(expected, recieved));
	}	
	
	@Test
	public void testJaggedRead() {
		String[][] recieved = null;
		try {
			recieved = Utility.read("C:\\Users\\family\\Documents\\Andrew's Stories\\Programming Comp 12-13\\Dec2013-Packet\\studentdata\\dico.dat");
		} catch (IOException e) {
			fail();
		}
		String[][] expected = {{"2","3","4","15","6","0"}, {"5","3","12","19","16","5","8","8","8","0"}, 
				{"1","11","4","2","2","12","20","2","12","0"}, {"14","18","0"}};
		assertTrue(Utility.isEqual(expected, recieved));
	}
	
	@Test
	public void equalsTest() {
		String[][] expected = {{"apple","banana","pear"}, {"dog", "parrot"}, {"faculty", "government", "taxes", "prisons"}};
		String[][] expectedClone = {{"apple","banana","pear"}, {"dog", "parrot"}, {"faculty", "government", "taxes", "prisons"}};
		String[][] unexpected = {{"apples","bananas","pears"}, {"dogs", "parrots"}, {"faculty", "governments", "tax", "prison"}};
		String[][] reallyUnexpected = {{"apple","banana"}, {"faculty", "government", "taxes", "prisons"}};
		assertTrue(Utility.isEqual(expected, expectedClone));
		assertFalse(Utility.isEqual(expected, unexpected));
		assertFalse(Utility.isEqual(expected, reallyUnexpected));
	}
	
//	@Test
	public void writeTest() {
		try {
			Utility.write("Your mother was a hamster and your father smelt of elderberries!", 
					"C:\\Users\\family\\git\\ApCompSci\\Classwork\\src\\fileio\\outagain.txt");
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void formatExperimentation() {
		String[][] strings = {{"Brian","Cranston", "two", "hamburgers", "Friday"}, 
				{"Aaron","Paul", "zero", "pizzas", "Tuesday"}, 
				{"RJ","Mitte", "fifteen", "tater tots", "Thursday"}, 
				{"Anna","Gunn", "seven", "egg rolls", "Sunday"}, 
				{"Dean","Morris", "three and a half", "cheeseburgers", "Wednesday"}};
		String output = Utility.basicFormat(strings);
//		String output = "";
//		for(int i = 0; i < strings.length; i++) {
//			String name = strings[i][0] + " " + strings[i][1];
//			String numFood = strings[i][2];
//			String typeFood = strings[i][3];
//			String day = strings[i][4];
//			output += String.format("%s had %s %s last %s.%n", name, numFood, typeFood, day);			
//		}
		try {
			Utility.write(output, "C:\\Users\\family\\git\\ApCompSci\\Classwork\\src\\fileio\\outagain.txt");
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

}
