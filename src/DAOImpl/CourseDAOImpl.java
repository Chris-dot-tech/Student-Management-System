package DAOImpl;

import java.sql.*;
import java.util.*;

import DAO.CourseDAO;
import DTO.Course;
import connection.ConnectionFactory;

public class CourseDAOImpl implements CourseDAO {

    //<--------------------------add Course------------------------------->

    public void addCourse(Course course) {

        try {

            Connection con = ConnectionFactory.RequestConnection();

            String q = "insert into course(course_name, duration, fees) values(?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setString(1, course.getCourse_name());
            pstmt.setString(2, course.getDuration());
            pstmt.setDouble(3, course.getFees());

            pstmt.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


     //<====================get all courses=========================>

    public List<Course> getAllCourse() {

        ArrayList<Course> courses = new ArrayList<>();

        try {

            Connection con = ConnectionFactory.RequestConnection();

            String q = "select * from course";

            PreparedStatement pstmt = con.prepareStatement(q);

            ResultSet res = pstmt.executeQuery();

            while (res.next()) {

                Course course = new Course();

                course.setCourse_id(res.getInt(1));
                course.setCourse_name(res.getString(2));
                course.setDuration(res.getString(3));
                course.setFees(res.getDouble(4));

                courses.add(course);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return courses;
    }


    //<====================get course by id============================>

    public Course getCourseById(int id) {

        try {

            Connection con = ConnectionFactory.RequestConnection();

            String q = "select * from course where course_id=?";

            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setInt(1, id);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {

                Course course = new Course();

                course.setCourse_id(res.getInt(1));
                course.setCourse_name(res.getString(2));
                course.setDuration(res.getString(3));
                course.setFees(res.getDouble(4));

                return course;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }


    //<=======================update course===========================>

    public void updateCourse(Course course) {

        try {

            Connection con = ConnectionFactory.RequestConnection();

            String q = "update course set course_name=?, duration=?, fees=? "
                     + "where course_id=?";

            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setString(1, course.getCourse_name());
            pstmt.setString(2, course.getDuration());
            pstmt.setDouble(3, course.getFees());
            pstmt.setInt(4, course.getCourse_id());

            pstmt.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    //<========================delete course=========================>

    public void deleteCourse(int id) {

        try {

            Connection con = ConnectionFactory.RequestConnection();

            String q = "delete from course where course_id=?";

            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    //<===========================search by name=============================>

    public List<Course> searchByName(String name) {

        ArrayList<Course> courses = new ArrayList<>();

        try {

            Connection con = ConnectionFactory.RequestConnection();

            String q = "select * from course where course_name like ?";

            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setString(1, "%" + name + "%");

            ResultSet res = pstmt.executeQuery();

            while (res.next()) {

                Course course = new Course();

                course.setCourse_id(res.getInt(1));
                course.setCourse_name(res.getString(2));
                course.setDuration(res.getString(3));
                course.setFees(res.getDouble(4));

                courses.add(course);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return courses;
    }


    //<============================search by duration=============================>

    public List<Course> searchByDuration(String duration) {

       ArrayList<Course> courses = new ArrayList<>();

        try {

            Connection con = ConnectionFactory.RequestConnection();

            String q = "select * from course where duration=?";

            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setString(1, duration);

            ResultSet res = pstmt.executeQuery();

            while (res.next()) {

                Course course = new Course();

                course.setCourse_id(res.getInt(1));
                course.setCourse_name(res.getString(2));
                course.setDuration(res.getString(3));
                course.setFees(res.getDouble(4));

                courses.add(course);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return courses;
    }


    //<============================search by fee range=============================>

    public List<Course> searchByFeeRange(double min, double max) {

        List<Course> courses = new ArrayList<>();

        try {

            Connection con = ConnectionFactory.RequestConnection();

            String q = "select * from course where fees between ? and ?";

            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setDouble(1, min);
            pstmt.setDouble(2, max);

            ResultSet res = pstmt.executeQuery();

            while (res.next()) {

                Course course = new Course();

                course.setCourse_id(res.getInt(1));
                course.setCourse_name(res.getString(2));
                course.setDuration(res.getString(3));
                course.setFees(res.getDouble(4));

                courses.add(course);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return courses;
    }


    //<==========================count courses==========================>

    public int countCourses() {

        try {

            Connection con = ConnectionFactory.RequestConnection();

            String q = "select count(*) from course";

            PreparedStatement pstmt = con.prepareStatement(q);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {

                return res.getInt(1);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return 0;
    }
}
