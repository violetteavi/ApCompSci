package fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utility {

	public static String[][] read(String path) throws IOException {
		BufferedReader inputStream = null;
		String[][] toReturn = null;
		
		try {
			inputStream = new BufferedReader(new FileReader(path));
			
			int numLines = Integer.parseInt(inputStream.readLine());
			toReturn = new String[numLines][];
			for(int i = 0; i < numLines; i++) {
				toReturn[i] = inputStream.readLine().split(" ");
			}
		} finally {
			if(inputStream != null) {
				inputStream.close();				
			}
		}
		return toReturn;
	}

	static boolean isEqual(String[][] expected, String[][] received) {
		if(expected==null||received==null) {
			return expected==null&&received==null;
		} else if(expected.length!=received.length) {
			return false;
		}
		for(int i = 0; i < expected.length; i++) {
			if(expected[i]==null||received[i]==null) {
				return expected==null&&received==null;
			} else if(expected[i].length!=received[i].length){
				return false;
			}
			for(int j = 0; j < expected[i].length; j++) {
				if(!expected[i][j].equals(received[i][j])) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static String basicFormat(String[][] strs) {
		String formatted = "";
		int numLines = strs.length;
		formatted += String.format("%d%n", numLines);
		for(int i = 0; i < numLines; i++) {
			for(int j = 0; j < strs[i].length; j++) {
				if(j!=0) {
					formatted+= " ";
				}
				formatted+= strs[i][j];
			}
			formatted+= "\r\n";
		}
		return formatted;
	}

	public static void write(String output, String path) throws IOException {
		BufferedWriter outputStream = null;
		
		try {
			outputStream = new BufferedWriter(new FileWriter(path));
			outputStream.write(output);
		} finally {
			if(outputStream!=null) {
				outputStream.close();
			}
		}
	}

}
