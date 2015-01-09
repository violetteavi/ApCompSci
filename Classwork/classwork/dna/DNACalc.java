package dna;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DNACalc {
	
	//S:\12\CS\dna.txt
	//S:\12\CS\dnaOutput.txt
	
	public static final int A = 0;
	public static final int C = 1;
	public static final int G = 2;
	public static final int T = 3;
	public static final int JUNK = 4;
	
	public static final double MASSA = 135.128;
	public static final double MASSC = 111.103;
	public static final double MASSG = 151.128;
	public static final double MASST = 125.107;
	public static final double MASSJUNK = 100;
	
	private static final int CODONLENGTH = 3;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Hello, and welcome to the DNACalc! This can be used to analyze possible proteins.");
		System.out.println("What file would you like to read from?");
		String inputPath = kb.nextLine();
		System.out.println("What file would you like to write to?");
		String outputPath = kb.nextLine();
		try {
			write(processDNAs(read(inputPath)), outputPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done!");
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

	private static String processDNAs(List<String> input) {
		String output = "";
		for(int i = 0; i < input.size(); i+=2) {
			output += processDNA(input.get(i), input.get(i + 1)) + "\n\n";
		}
		return output;
	}

	private static String processDNA(String name, String rawNucleotides) {
		String processed = "";
		processed += "Region Name: " + name + "\n";
		String caps = allCaps(rawNucleotides);
		processed += "Nucleotides: " + caps + "\n";
		int[] count = countNucs(caps);
		processed += "Nuc. Counts: " + String.format("[%d, %d, %d, %d]", count[A], count[C], count[G], count[T]) + "\n";
		double[] composition = getComposition(count);
		processed += "Total Mass%: " + String.format("[" + composition[A] + ", " + composition[C] + ", " + 
				composition[G] + ", " + composition[T] + "] of " + composition[4]) + "\n";
		String[] codons = toCodons(caps);
		processed += "Codons List: " + Arrays.toString(codons) + "\n";
		String isAProtein = isProtein(codons, composition);
		processed += "Is Protein?: " + isAProtein;
		return processed;
	}

	private static String isProtein(String[] codons, double[] composition) {
		if(!(composition[C] + composition[G] >= 30)) {
			return "NO";
		}
		if(!(codons.length >= 5)) {
			return "NO";
		}
		if(!codons[0].equals("ATG")) {
			return "NO";
		}
		String lastCodon = codons[codons.length - 1];
		if(!(lastCodon.equals("TAA")||lastCodon.equals("TAG")||lastCodon.equals("TGA"))) {
			return "NO";
		}
		return "YES";
	}

	private static String[] toCodons(String caps) {
		String filtered = filterJunk(caps);
		String[] codons = new String[filtered.length()/3];
		for(int i = 0; i < codons.length; i++) {
			codons[i] = "";
		}
		int index = 0;
		for(int i = 0; i < codons.length; i++) {
			for(int j = 0; j < CODONLENGTH; j++) {
				codons[i] += filtered.charAt(index);
				index++;
			}
		}
		return codons;
	}

	private static String filterJunk(String caps) {
		String filtered = "";
		for(int i = 0; i < caps.length(); i++) {
			if(caps.charAt(i)!='-') {
				filtered+= caps.charAt(i);
			}
		}
		return filtered;
	}

	public static double[] getComposition(int[] count) {
		double[] composition = new double[5];
		double total = count[A] * MASSA + 
						count[C] * MASSC + 
						count[G] * MASSG + 
						count[T] * MASST + 
						count[JUNK] * MASSJUNK;
		composition[4] = ((double) Math.round(10 * total)) / 10;
		composition[A] = ((double) Math.round(10 * 100 * count[A] * MASSA / total)) / 10;
		composition[C] = ((double) Math.round(10 * 100 * count[C] * MASSC / total)) / 10;
		composition[G] = ((double) Math.round(10 * 100 * count[G] * MASSG / total)) / 10;
		composition[T] = ((double) Math.round(10 * 100 * count[T] * MASST / total)) / 10;
		return composition;
	}

	private static int[] countNucs(String caps) {
		int[] count = new int[5];
		for(int i = 0; i < caps.length(); i++) {
			switch (caps.charAt(i)) {
			case 'A': count[A]++; break;
			case 'C': count[C]++; break;
			case 'G': count[G]++; break;
			case 'T': count[T]++; break;
			case '-': count[JUNK]++; break;
			}
		}
		return count;
	}

	private static String allCaps(String rawNucleotides) {
		String caps = "";
		for(int i = 0; i < rawNucleotides.length(); i++) {
			char ch = rawNucleotides.charAt(i);
			switch (ch) {
			case 'a': caps+= 'A'; break;
			case 'A': caps+= 'A'; break;
			case 'c': caps+= 'C'; break;
			case 'C': caps+= 'C'; break;
			case 'g': caps+= 'G'; break;
			case 'G': caps+= 'G'; break;
			case 't': caps+= 'T'; break;
			case 'T': caps+= 'T'; break;
			case '-': caps+= '-'; break;
			}
		}
		return caps;
	}

	private static List<String> read(String inputPath) throws FileNotFoundException {
		List<String> input = new LinkedList<String>();
		Scanner sc = null;
		sc = new Scanner(new File(inputPath));			
		while(sc.hasNextLine()) {
			input.add(sc.nextLine());
		}
		return input;
	}
}
