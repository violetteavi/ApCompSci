package jan30;

public class DownloadInfo {

	private String title;
	private int timesDownloaded;

	public DownloadInfo(String songTitle) {
		title = songTitle;
	}

	public String getTitle() {
		return title;
	}

	public void incrementTimesDownloaded() {
		timesDownloaded++;
	}

}
