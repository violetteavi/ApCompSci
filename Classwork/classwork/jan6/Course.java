package jan6;

import java.util.List;

public class Course {

	private String courseTitle;
	private String teacherName;
	private int roomNumber;
	private List<Student> students;
	
	
	public Course(String courseTitle, String teacherName, int roomNumber,
			List<Student> students) {
		this.courseTitle = courseTitle;
		this.teacherName = teacherName;
		this.roomNumber = roomNumber;
		this.students = students;
	}
	
	public void addStudent(Student s) {
		students.add(s);
	}
	
	public void removeStudent(Student s) {
		students.remove(s);
	}
	
	public boolean isEnrolled(Student s) {
		return students.contains(s);
	}
	
	public boolean hasSameTeacher(Course other) {
		return teacherName.equals(other.getTeacherName());
	}
	
	public boolean isEqual(Course other) {
		if(!courseTitle.equals(other.getCourseTitle())) {
			return false;
		} else if(!teacherName.equals(other.getTeacherName())) {
			return false;
		} else if(roomNumber!=other.getRoomNumber()) {
			return false;
		}
		for(Student s: students) {
			if(!other.isEnrolled(s)) {
				return false;
			}
		}
		for(Student s: other.getStudents()) {
			if(!this.isEnrolled(s)) {
				return false;
			}
		}
		return true;
	}
	
	//getters and setters	
	
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
