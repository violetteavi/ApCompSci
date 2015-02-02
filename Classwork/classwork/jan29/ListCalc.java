package jan29;

import jan6.Course;

import java.util.ArrayList;

public class ListCalc {
	
	public static int indexOf(double[] nums, double target) {
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	public static boolean hasTeacher(ArrayList<Course> courses, String teacherName) {
		for(Course course: courses) {
			if(course.getTeacherName().equals(teacherName)) {
				return true;
			}
		}
		return false;
	}

}
