package DAO;

import java.util.List;

import DTO.Course;

public interface CourseDAO {

	void addCourse(Course course);
	
	List getAllCourse();
	
	Course getCourseById(int id);
	
	void updateCourse(Course course);
	
	void deleteCourse(int id);
	
	List searchByName(String name);
	
	List searchByDuration(String duration);
	
	List searchByFeeRange(double min , double max);
	
	int countCourses();
	
	
}
