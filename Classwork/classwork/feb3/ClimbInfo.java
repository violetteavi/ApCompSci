package feb3;

public class ClimbInfo implements Comparable<ClimbInfo>{

	private String peak;
	private int climbTime;
	
	public ClimbInfo(String peak, int climbTime) {
		this.peak = peak;
		this.climbTime = climbTime;
	}
	
	public String getPeak() {
		return peak;
	}
	
	public int getClimbTime() {
		return climbTime;
	}

	@Override
	public int compareTo(ClimbInfo that) {
		return this.getPeak().compareTo(that.getPeak());
	}

}
