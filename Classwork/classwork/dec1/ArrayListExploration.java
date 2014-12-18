package dec1;

import java.util.ArrayList;

public class ArrayListExploration {

	public static void main(String[] args) {
//		ArrayList<String> myList = new ArrayList<String>();
//		myList.add("hello");
//		myList.add("goodbye");
//		myList.set(0, "bye");
//		printAll(myList);
//		removeAll(myList);
//		System.out.println(myList.size());
//		ArrayList<Integer> myList2 = new ArrayList<Integer>();
//		myList2.add(1);
//		myList2.add(2);
//		myList2.add(3);
//		int x = 5;
//		myList2.add(x);
//		int n = myList2.get(0);
//		System.out.println(n);
//		ArrayList<Object> myList3 = new ArrayList<Object>();
//		myList3.add(2.154);
//		myList3.add('h');
//		System.out.println(myList3.get(0));
//		System.out.println(myList3.get(1));
		char[] chars = new char[5];
		chars[0] = 'a';
		chars[1] = 'b';
		chars[2] = 'c';
		chars[3] = ' ';
		chars[4] = 'd';
		System.out.println(charToString(fill(chars)));
	}
	
	public static ArrayList<Character> fill(char[] objs) {
		ArrayList<Character> returnable = new ArrayList<Character>();
		for(int i = 0; i < objs.length; i++) {
			returnable.add(objs[i]);
		}
		return returnable;
	}
	
	public static String charToString(ArrayList<Character> chars) {
		String returnable = "";
		for(int i = 0; i < chars.size(); i++) {
			returnable += chars.get(i);
		}
		return returnable;
	}
	
	private static void removeAll(ArrayList<String> myList) {
		while(!myList.isEmpty()) {
			myList.remove(0);
		}
	}

	public static void printAll(ArrayList<String> myList) {
		for(int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
		}
	}
}
