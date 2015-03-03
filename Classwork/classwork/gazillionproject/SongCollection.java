package gazillionproject;

import java.util.ArrayList;

public class SongCollection {

	private ArrayList<Song> songs;
	
	public SongCollection(ArrayList<Song> songs) {
		this.songs = songs;
	}
	
	public void filterYear(Range r) {
		for(Song song: songs) {
			if(!r.contains(song)) {
				songs.remove(song);
			}
		}
	}
}
