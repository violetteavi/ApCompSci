package gazillionproject;

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
		System.out.println("Enter sort/filter command: ");
		String command = kb.nextLine();
		System.out.println("Enter output file:");
		String outputPath = kb.nextLine();
		try {
			write(processSongs(read(inputPath), command), outputPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done!");
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

}
