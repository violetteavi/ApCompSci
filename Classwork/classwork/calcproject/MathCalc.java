package calcproject;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MathCalc {
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Type your response, then hit enter");
		boolean done = false;
		while(!done) {
			System.out.println("What expression would you like to evaluate?");
			String input = kb.nextLine();
			if(!input.equalsIgnoreCase("quit")) {
				List<String> parsedInput = parse(input);
				String result = evaluate(parsedInput);
				System.out.println(input + " is evaluated as " + result);
			} else {
				done = true;
			}
		}		
	}

	public static String evaluate(List<String> parsedInput) {
		String toReturn = null;
		boolean done = false;
		int priority = 4;
		while(!done) {
			for(int i = 0; i < parsedInput.size(); i++) {
				String str = parsedInput.get(i);
				if(isOperator(str)) {
					switch(priority) {
						case 4:	if(str.equals("|")||str.equals("v")||str.equals("~")||str.equals("s")||str.equals("c")||str.equals("t")) {
									String operator = parsedInput.get(i);
									String operand = parsedInput.get(i + 1);
									parsedInput.remove(i);
									parsedInput.remove(i);
									parsedInput.add(i, calcOneOperand(operator, operand));
								}
							break;
						case 3:  if(str.equals("^")) {
									String operator = parsedInput.get(i);
									String operand1 = parsedInput.get(i - 1);
									String operand2 = parsedInput.get(i + 1);
									parsedInput.remove(i - 1);
									parsedInput.remove(i - 1);
									parsedInput.remove(i - 1);
									parsedInput.add(i - 1, calcTwoOperands(operator, operand1, operand2));
								}
							break;
						case 2:  if(str.equals("*")||str.equals("/")) {
									String operator = parsedInput.get(i);
									String operand1 = parsedInput.get(i - 1);
									String operand2 = parsedInput.get(i + 1);
									parsedInput.remove(i - 1);
									parsedInput.remove(i - 1);
									parsedInput.remove(i - 1);
									parsedInput.add(i - 1, calcTwoOperands(operator, operand1, operand2));
								}
							break;

						case 1:  if(str.equals("+")||str.equals("-")) {
									String operator = parsedInput.get(i);
									String operand1 = parsedInput.get(i - 1);
									String operand2 = parsedInput.get(i + 1);
									parsedInput.remove(i - 1);
									parsedInput.remove(i - 1);
									parsedInput.remove(i - 1);
									parsedInput.add(i - 1, calcTwoOperands(operator, operand1, operand2));
								}
							break;
						case 0:  done = true;
							break;
					}
				}
			}
			priority--;
		}
		return toReturn;
	}

	public static String calcOneOperand(String operator, String operand) {
		if(operator.equals("|")) {
			return String.valueOf(abs(Double.valueOf(operand)));
		} else if(operator.equals("v")) {
			return String.valueOf(sqrt(Double.valueOf(operand)));
		} else if(operator.equals("~")) {
			return String.valueOf(round(Double.valueOf(operand)));
		} else if(operator.equals("s")) {
			return String.valueOf(sin(Double.valueOf(operand)));
		} else if(operator.equals("c")) {
			return String.valueOf(cos(Double.valueOf(operand)));
		} else if(operator.equals("t")) {
			return String.valueOf(tan(Double.valueOf(operand)));
		} else {
			return null;
		}
	}

	public static String calcTwoOperands(String operator, String operand1, String operand2) {
		if(operator.equals("^")) {
			return String.valueOf(pow(Double.valueOf(operand1),Double.valueOf(operand2)));
		} else if(operator.equals("*")) {
			return String.valueOf(multiply(Double.valueOf(operand1),Double.valueOf(operand2)));
		} else if(operator.equals("/")) {
			return String.valueOf(divide(Double.valueOf(operand1),Double.valueOf(operand2)));
		} else if(operator.equals("+")) {
			return String.valueOf(add(Double.valueOf(operand1),Double.valueOf(operand2)));
		} else if(operator.equals("-")) {
			return String.valueOf(subtract(Double.valueOf(operand1),Double.valueOf(operand2)));
		}
		return null;
	}

	public static List<String> parse(String string) {
		List<String> toReturn = new LinkedList<String>();
		String temp = "";
		for(int i = 0; i < string.length(); i++) {			
			if(string.charAt(i) != ' ') {
				temp += string.charAt(i);
			} else {
				toReturn.add(temp);
				temp = "";
			}
		}
		toReturn.add(temp); // no space at the end of the string, must store temp 		
		return toReturn;
	}

	public static boolean isOperator(String string) {
		if(string.length() != 1) {
			return false;
		}
		if(string.equals("+")) {
			return true;
		} else if(string.equals("-")) {
			return true;
		} else if(string.equals("*")) {
			return true;
		} else if(string.equals("/")) {
			return true;
		} else if(string.equals("^")) {
			return true;
		} else if(string.equals("|")) {
			return true;
		} else if(string.equals("v")) {
			return true;
		} else if(string.equals("~")) {
			return true;
		} else if(string.equals("s")) {
			return true;
		} else if(string.equals("c")) {
			return true;
		} else if(string.equals("t")) {
			return true;
		}
		return false;
	}

	public static double add(double a, double b) {
		return a + b;
	}

	public static double subtract(double a, double b) {
		return a - b;
	}

	public static double multiply(double a, double b) {
		return a * b;
	}

	public static double divide(double a, double b) {
		return a / b;
	}

	public static double pow(double a, double b) {
		return Math.pow(a, b);
	}

	public static double abs(double a) {
		return Math.abs(a);
	}

	public static int round(double a) {
		return (int) Math.round(a);
	}

	public static double sqrt(double a) {
		return Math.sqrt(a);
	}

	public static double sin(double a) {
		return Math.sin(a);
	}

	public static double cos(double a) {
		return Math.cos(a);
	}

	public static double tan(double a) {
		return Math.tan(a);
	}

	public static boolean isEqual(List<String> expected, List<String> received) {
		if(expected==null||received==null) {
			return expected==null&&received==null;
		} else if(expected.size()!=received.size()) {
			return false;
		}
		for(int i = 0; i < expected.size(); i++) {
			if(!expected.get(i).equals(received.get(i))) {
				return false;
			}
		}
		return true;
	}

}
