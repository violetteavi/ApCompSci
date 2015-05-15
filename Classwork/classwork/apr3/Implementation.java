package apr3;

import java.util.LinkedList;
import java.util.List;

public class Implementation implements CountableNumberList, Printable {

	private List<Double> nums;
	
	public Implementation() {
		nums = new LinkedList<Double>();
	}
	
	@Override
	public int count() {
		return nums.size();
	}

	@Override
	public String getDescription() {
		if(nums.size()==0) {
			return "{}";
		}
		String string = "{" + nums.get(0);
		for(int i = 1; i < nums.size(); i++) {
			string += ", " + nums.get(i);
		}
		string += "}";
		return string;
	}

	@Override
	public void add(double num) {
		nums.add(num);
	}

	@Override
	public void removeLast() {
		if(nums.size()==0) {
			return;
		}
		nums.remove(nums.size()-1);
	}

	@Override
	public double sum() {
		double total = 0;
		for(double num: nums) {
			total += num;
		}
		return total;
	}

}
