package feb3;

import java.util.Arrays;
import java.util.List;

public class ClimbingClub {

	private List<ClimbInfo> climbs;
	
	public void addClimb(String peak, int climbTime) {
		climbs.add(new ClimbInfo(peak, climbTime));
	}
	
	public void addClimbAlphebetical(String peak, int climbTime) {
		climbs.add(new ClimbInfo(peak, climbTime));
		sortAlphebetical();
	}

	private void sortAlphebetical() {
		boolean changed = true;
		while(changed) {
			changed = false;
			if(climbs.size() > 0) {
				ClimbInfo previous = climbs.get(0);
				ClimbInfo current = null;
				for(int i = 1; i < climbs.size(); i++) {
					current = climbs.get(i);
					if(previous.compareTo(current)>0) {
						climbs.remove(i);
						climbs.add(i - 1, current);
						changed = true;
					} else {
						previous = current;
					}
				}
			}
		}
	}
}
