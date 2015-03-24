package projects.gazillionproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GazillionSongs {
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Hello, and welcome to the SongCalc! This can be used to filter and sort songs.");
		System.out.println("Enter input file: ");
		String inputPath = kb.nextLine();
		if(!fileExists(inputPath)) {
			System.out.println("File does not exist. Exiting...");
			return;
		}
		System.out.println("Enter sort/filter command: ");
		String command = kb.nextLine();
		System.out.println("Enter output file:");
		String outputPath = kb.nextLine();
		if(fileExists(outputPath)) {
			System.out.println("File already exists. Would you like to continue? y/n");
			String answer = kb.nextLine();
			if(!answer.contains("y")) {
				System.out.println("Exiting...");
				return;
			}
		}
		try {
			write(processSongs(read(inputPath), command), outputPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done!");
	}

	private static boolean fileExists(String path) {
		File f = new File(path);
		return f.exists();
	}

	private static String processSongs(List<Song> bareSongs, String command) {
		SongCollection songs = new SongCollection(bareSongs);
		songs.operate(command);
		return songs.toString();
	}

	private static void write(String output, String outputPath) throws IOException {
		BufferedWriter outputStream = null;
		try {
			outputStream = new BufferedWriter(new FileWriter(new File(outputPath)));
			outputStream.write(output);
		} finally {
			if(outputStream!=null) {
				outputStream.close();
			}
		}
	}

	private static List<Song> read(String inputPath) throws FileNotFoundException {
		List<Song> input = new LinkedList<Song>();
		Scanner sc = null;
		sc = new Scanner(new File(inputPath));			
		while(sc.hasNextLine()) {
			input.add(Song.parse(sc.nextLine()));
		}
		return input;
	}

	/* example io
	 * Hello, and welcome to the SongCalc! This can be used to filter and sort songs.
Enter input file: 
S:\12\CS\agazillionsongs.txt
Enter sort/filter command: 
-title:money -sort:rank
Enter output file:
S:\12\CS\moneySortTest.txt
Done!-year:1990-1999 -rank:1-10
	 */
}
