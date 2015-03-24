package projects.gazillionproject;

public class Song {
	
	private int year;
	private int rank;
	private String artist;
	private String title;

	public static Song parse(String s) {
		String[] vals = s.split("\t");
		return new Song(Integer.parseInt(vals[0]), Integer.parseInt(vals[1]), vals[2], vals[3]);
	}

	private Song(int year, int rank, String artist, String title) {
		this.year = year;
		this.rank = rank;
		this.artist = artist;
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public int getRank() {
		return rank;
	}

	public String getArtist() {
		return artist;
	}

	public String getTitle() {
		return title;
	}
	
	public String toString() {
		return year + "\t" + rank + "\t" + artist + "\t" + title;
	}
}
