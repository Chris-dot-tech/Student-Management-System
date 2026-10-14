package DTO;

public class Course {

	private int course_id;
	private String course_name;
	private String duration;
	private double fees;
	
	public Course(){
		super();
	}
	Course(int course_id, String course_name, String duration , int fees){
		
		this.course_id = course_id;
		this.course_name = course_name;
		this.duration = duration; 
		this.fees = fees;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}
	
	@Override
	public String toString() {
		return "Course[course_id = " + course_id + ", course_name = " + course_name + ", duration = " + duration + ", fees = " + fees + "]";
	}
}
