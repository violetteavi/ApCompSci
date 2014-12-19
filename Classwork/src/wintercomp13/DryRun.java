package wintercomp13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DryRun {
	public static final String INPUT_PATH = "C:\\Users\\family\\Documents\\Andrew's Stories\\Programming Comp 12-13\\Dec2013-Packet\\studentdata\\bad.dat";
	public static final String OUTPUT_PATH = "C:\\outagain.txt";
	
	public static void main(String[] args) {
		try {
			File inputFile = new File(System.getProperty("user.dir"), "src\\wintercomp13\\dryruninput");
			String[] input = read(inputFile);
			File outputFile = new File(System.getProperty("user.dir"), "src\\wintercomp13\\dryrunoutput");
			write(toFormat(input), outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static String toFormat(String[] jobs) {
		String formatted = "";
		int numLines = jobs.length;
		formatted+= numLines + "\r\n";
		for(int i = 0; i < numLines; i++) {
			formatted+= String.format("I wish I were a %s.%n", jobs[i]);
		}
		return formatted;
	}
	
	public static String[] read(File inputFile) throws IOException {
		BufferedReader inputStream = null;
		String[] toReturn = null;
		try {
			inputStream = new BufferedReader(new FileReader(inputFile));
			int numLines = Integer.parseInt(inputStream.readLine());
			toReturn = new String[numLines];
			for(int i  = 0; i < numLines; i++) {
				toReturn[i] = inputStream.readLine();
			}
		} finally {
			if(inputStream!=null) {
				inputStream.close();
			}
		}
		return toReturn;
	}
	
	public static void write(String output, File outputFile) throws IOException {
		BufferedWriter outputStream = null;
		try { 
			outputStream = new BufferedWriter(new FileWriter(outputFile));
			outputStream.write(output);
		} finally {
			if(outputStream!= null) {
				outputStream.close();
			}
		}
	}
}
