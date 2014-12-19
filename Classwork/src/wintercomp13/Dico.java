package wintercomp13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Dico {
	
	public static void main(String[] args) {
		LinkedList<Boolean[]> list = new LinkedList<Boolean[]>();
		Boolean[] bools = {true, false, false, true}; 
		list.add(0, bools);
		File inputFile = new File(System.getProperty("user.dir"), "src\\wintercomp13\\dicoinput");
		try {
			System.out.println(playGames(read(inputFile)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String[][] read(File inputFile) throws IOException {
		BufferedReader inputStream = null;
		String[][] input = null;
		try {
			inputStream = new BufferedReader(new FileReader(inputFile));
			int numLines = Integer.parseInt(inputStream.readLine());
			input  = new String[numLines][];
			for(int i = 0; i < numLines; i++) {
				input[i] = inputStream.readLine().split(" ");
			}
			throw new IOException();
		} finally {
			if(inputStream!=null) {
				inputStream.close();
			}
		}
//		return input;
	}
	
	public static String playGames(String[][] inputs) {
		String results = "";
		for(int i = 0; i < inputs.length; i++) {
			results += playGame(inputs[i]) + "\n";
		}
		return results;
	}
	
	public static String playGame(String[] input) {
		List<String> lose = new LinkedList<String>();
		lose.add("2");
		lose.add("3");
		lose.add("10");
		lose.add("13");
		lose.add("19");
		List<String> win = new LinkedList<String>();
		win.add("7");
		win.add("11");
		win.add("15");
		win.add("20");
		boolean firstRoll = true;
		int numRolls = 0;
		for(int i = 0; i < input.length; i++) {
			String roll = input[i];
			numRolls++;
			for(String s: lose) {
				if(s.equals(roll)) {
					return "LOSS " + numRolls;
				}
			}
			for(String s: win) {
				if(s.equals(roll)) {
					return "WIN " + numRolls;
				}
			}
			if(firstRoll) {
				lose.clear();
				lose.add("7");
				lose.add("10");
				lose.add("11");
				lose.add("15");
				win.clear();
				win.add(input[i]);
				firstRoll = false;
			}
		}
		return "NO RESULT " + (numRolls - 1);
	}
	
	
}
