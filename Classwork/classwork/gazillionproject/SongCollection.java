package gazillionproject;

import java.util.ArrayList;
import java.util.List;

public class SongCollection {

	private List<Song> songs;
	
	public SongCollection(List<Song> songs) {
		this.songs = songs;
	}
	
	public String toString() {
		int counter = 0;
		String str = "";
		for(Song song: songs) {
			str += song.toString() + "\n";
			counter++;
			if(counter >= 1000) {
				counter = 0;
				System.out.println("This is big");
			}
		}
		return str;
	}
	
	
	public void filterYear(Range r) {
		for(int i = 0; i < songs.size(); i++) {
			if(!r.contains(songs.get(i).getYear())) {
				songs.remove(i);
				i--;
			}
		}
	}
	
	public void filterRank(Range r) {
		for(int i = 0; i < songs.size(); i++) {
			if(!r.contains(songs.get(i).getRank())) {
				songs.remove(i);
				i--;
			}
		}
	}
	
	public void filterArtist(String s) {
		for(int i = 0; i < songs.size(); i++) {
			if(!songs.get(i).getArtist().toLowerCase().contains(s)) {
				songs.remove(i);
				i--;
			}
		}
	}
	
	public void filterTitle(String s) {
		for(int i = 0; i < songs.size(); i++) {
			if(!songs.get(i).getTitle().toLowerCase().contains(s)) {
				songs.remove(i);
				i--;
			}
		}
	}
	
	public void sortYear() {
		for(int i = 0; i < songs.size(); i++) {
			int imax = i;
			int maxYear = songs.get(i).getYear();
			for(int j = i + 1; j < songs.size(); j++) {
				if(songs.get(j).getYear()<maxYear) {
					imax = j;
					maxYear = songs.get(j).getYear();
				}
			}
			insert(i, imax);
		}
	}
	
	public void sortRank() {
		for(int i = 0; i < songs.size(); i++) {
			int imax = i;
			int maxRank = songs.get(i).getRank();
			for(int j = i + 1; j < songs.size(); j++) {
				if(songs.get(j).getRank()<maxRank) {
					imax = j;
					maxRank = songs.get(j).getRank();
				}
			}
			insert(i, imax);
		}
	}

	private void insert(int target, int toPlace) {
		songs.add(target, songs.get(toPlace));
		songs.remove(toPlace + 1);
	}

	public void operate(String operations) {
		String[] commands = operations.split(" ");
		for(String command: commands) {
			String[] divided = command.split(":");
			if(divided[0].toLowerCase().contains("year")) {
				Range toFilter = Range.parse(divided[1]);
				this.filterYear(toFilter);
			}
			if(divided[0].toLowerCase().contains("rank")) {
				Range toFilter = Range.parse(divided[1]);
				this.filterRank(toFilter);
			}
			if(divided[0].toLowerCase().contains("artist")) {
				this.filterArtist(divided[1]);
			}		
			if(divided[0].toLowerCase().contains("title")) {
				this.filterTitle(divided[1]);
			}
			if(divided[0].toLowerCase().contains("sort")) {
				if(divided[1].toLowerCase().contains("year")) {
					this.sortYear();
				}
				if(divided[1].toLowerCase().contains("rank")) {
					this.sortRank();
				}
				if(divided[1].equals("artist")) {
					this.sortArtist();
				}
				if(divided[1].equals("title")) {
					this.sortTitle();
				}
			}
		}
	}

	private void sortTitle() {
		for(int i = 0; i < songs.size(); i++) {
			int imax = i;
			String maxTitle = songs.get(i).getTitle();
			for(int j = i + 1; j < songs.size(); j++) {
				if(songs.get(j).getTitle().compareToIgnoreCase(maxTitle) < 0) {
					imax = j;
					maxTitle = songs.get(j).getTitle();
				}
			}
			insert(i, imax);
		}
	}

	private void sortArtist() {
		for(int i = 0; i < songs.size(); i++) {
			int imax = i;
			String maxArtist = songs.get(i).getArtist();
			for(int j = i + 1; j < songs.size(); j++) {
				if(songs.get(j).getArtist().compareToIgnoreCase(maxArtist) < 0) {
					imax = j;
					maxArtist = songs.get(j).getArtist();
				}
			}
			insert(i, imax);
		}
	}
	

}
