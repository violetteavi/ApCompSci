package calcproject;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MathCalc {
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to the AP Computer Science Calculator!\n");
		String input;
		do {
			System.out.print("Enter an expression, or quit to exit: ");
			input = kb.nextLine();
			try {
				List<String> parsedInput = parse(input);
				String result = evaluate(parsedInput);
				System.out.println(input + " = " + result);
			} catch (Exception e) {
				System.out.println("Invalid expression. Try again, making sure to leave a space between operators and operands.");
			}
		} while(!input.equalsIgnoreCase("quit"));
		System.out.println("Thanks for stopping by!");
	}

	public static String evaluate(List<String> parsedInput) {
		List<String> evaluatable = parsedInput;
		int priority = 5;
		while(priority!=0) {
			for(int i = 0; i < evaluatable.size(); i++) {
				String str = evaluatable.get(i);
				if(isOperator(str)) {
					switch(priority) {
						case 5:	if(str.equals("(")) {
									List<String> subEquation = new LinkedList<String>();
									int numParen = 1;
									evaluatable.remove(i);
									while(numParen!=0) {
										if(evaluatable.get(i).equals("(")) {
											numParen++;
										} else if(evaluatable.get(i).equals(")")) {
											numParen--;
										}
										subEquation.add(evaluatable.get(i));
										evaluatable.remove(i);
									}
									subEquation.remove(subEquation.size() - 1); //last value is close parentheses
									evaluatable.add(i, evaluate(subEquation));
								}
							break;
						case 4:	if(str.equals("|")||str.equals("v")||str.equals("~")||str.equals("s")||str.equals("c")||str.equals("t")) {
									String operator = evaluatable.get(i);
									String operand = evaluatable.get(i + 1);
									evaluatable.remove(i);
									evaluatable.remove(i);
									evaluatable.add(i, calcOneOperand(operator, operand));
								}
							break;
						case 3:  if(str.equals("^")) {
									String operator = evaluatable.get(i);
									String operand1 = evaluatable.get(i - 1);
									String operand2 = evaluatable.get(i + 1);
									evaluatable.remove(i - 1);
									evaluatable.remove(i - 1);
									evaluatable.remove(i - 1);
									evaluatable.add(i - 1, calcTwoOperands(operator, operand1, operand2));
								}
							break;
						case 2:  if(str.equals("*")||str.equals("/")) {
									String operator = evaluatable.get(i);
									String operand1 = evaluatable.get(i - 1);
									String operand2 = evaluatable.get(i + 1);
									evaluatable.remove(i - 1);
									evaluatable.remove(i - 1);
									evaluatable.remove(i - 1);
									evaluatable.add(i - 1, calcTwoOperands(operator, operand1, operand2));
								}
							break;

						case 1:  if(str.equals("+")||str.equals("-")) {
									String operator = evaluatable.get(i);
									String operand1 = evaluatable.get(i - 1);
									String operand2 = evaluatable.get(i + 1);
									evaluatable.remove(i - 1);
									evaluatable.remove(i - 1);
									evaluatable.remove(i - 1);
									evaluatable.add(i - 1, calcTwoOperands(operator, operand1, operand2));
								}
							break;
					}
				}
			}
			priority--;
		}
		Double.valueOf(evaluatable.get(0)); //throws an exception that can be caught up top.
		return evaluatable.get(0);
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
		} else if(string.equals("(")) {
			return true;
		} else if(string.equals(")")) {
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
