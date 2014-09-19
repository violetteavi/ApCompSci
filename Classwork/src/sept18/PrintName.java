package sept18;

public class PrintName {

	public static void main(String[] args) {
		PrintName.printFirst();
		System.out.print(" ");
		PrintName.printLast();
		System.out.println();
		
		PrintName.printFirst();
		System.out.print(" ");
		PrintName.printMiddle();
		System.out.print(" ");
		PrintName.printLast();
		System.out.println();
		
		PrintName.printLast();
		System.out.print(", ");
		PrintName.printFirst();
		System.out.println();
//
//		PrintName.printLast();
//		System.out.print(", ");
//		PrintName.printFirst();
//		System.out.print(" ");
//		PrintName.printMiddle();
//		System.out.println();
	}
	
	public static void printFirst() {
		System.out.print("Andrew");
	}
	
	public static void printMiddle() {
		System.out.print("Mark");
	}
	
	public static void printLast() {
		System.out.print("Violette");
	}
}
