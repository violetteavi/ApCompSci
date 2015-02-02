package jan30;

import java.util.List;

public class MusicDownloads {
	
	private List<DownloadInfo> downloadList;

	public DownloadInfo getDownloadInfo(String title) {
		for(DownloadInfo dI: downloadList) {
			if(dI.getTitle().equals(title)) {
				return dI;
			}
		}
		return null;
	}
	
	public void updateDownloads(List<String> songTitles) {
		for(String songTitle: songTitles) {
			if(getDownloadInfo(songTitle)!=null) {
				getDownloadInfo(songTitle).incrementTimesDownloaded();
			} else {
				downloadList.add(new DownloadInfo(songTitle));
			}
		}
	}
}
