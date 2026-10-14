package DAOImpl;

import java.sql.*;
import java.util.*;

import DAO.StudentDAO;
import DTO.Student;
import connection.ConnectionFactory;


public class StudentDAOImpl  implements StudentDAO{
	
//<--------------------------add Student------------------------------->
	
	public void addStudent(Student student) {
		try {
		Connection con = ConnectionFactory.RequestConnection();
		
		String q = "insert into student(name, email, phone, age)values(?,?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(q);
		
		pstmt.setString(1, student.getName());
		pstmt.setString(2, student.getEmail());
		pstmt.setString(3, student.getPhone());
		pstmt.setInt(4, student.getAge());
		
		pstmt.executeUpdate();
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//<====================get all students =========================>
	
	public List<Student> getAllStudent(){
		
		List<Student> students = new ArrayList<>();
		try {
		Connection con = ConnectionFactory.RequestConnection();
		
		String q = "select * from student";
		
		PreparedStatement pstmt = con.prepareStatement(q);
		
		
		
		ResultSet res = pstmt.executeQuery();
		
		while(res.next()) {
			Student student = new Student();
			
			student.setStudent_id(res.getInt(1));
			student.setName(res.getString(2));
			student.setEmail(res.getString(3));
			student.setPhone(res.getString(4));
			student.setAge(res.getInt(5));
			
			students.add(student);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return students;
	}
	
	//<====================get student by id ============================>
	
   public Student getStudentById(int id) {
	   
	   try {
	   Connection con = ConnectionFactory.RequestConnection();
	   
	   String q = "select * from student where student_id=?";
	   
	   PreparedStatement pstmt = con.prepareStatement(q);
	   
	   pstmt.setInt(1, id);
	   
	   ResultSet res = pstmt.executeQuery();
	   
	   if(res.next()) {
		   
		   Student student = new Student();
		   
		   student.setStudent_id(res.getInt(1));
		   student.setName(res.getString(2));
		   student.setEmail(res.getString(3));
		   student.setPhone(res.getString(4));
		   student.setAge(res.getInt(5));
		   
		   return student;
	   }
	   
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   return null;
   }
   
   //<=======================update student===========================>
   
   public void updateStudent(Student student) {
	   try {
		   Connection con = ConnectionFactory.RequestConnection();
		   
		   String q = "update student set name=?, email=?, phone=?, age=? where student_id=? ";
		   
		   PreparedStatement pstmt = con.prepareStatement(q);
		   
		   pstmt.setString(1, student.getName());
		   pstmt.setString(2, student.getEmail());
		   pstmt.setString(3, student.getPhone());
		   pstmt.setInt(4, student.getAge());
		   pstmt.setInt(5, student.getStudent_id());
		   
		    pstmt.executeUpdate();
		   
		   
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   
   //<========================delete student=========================>
	
	public void deleteStudent(int id) {
		try {
			Connection con = ConnectionFactory.RequestConnection();
			
			String q = "delete from student where student_id =?";
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//<===========================search by name=============================>
	
	public List<Student> searchByName(String name) {
		
		List <Student> students = new ArrayList();
		
		try {
			
			Connection con = ConnectionFactory.RequestConnection();
			
			String q = "select * from student where name like ?";
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setString(1, "%" + name + "%");
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				Student student = new Student();
				
				student.setStudent_id(res.getInt(1));
				student.setName(res.getString(2));
				student.setEmail(res.getString(3));
				student.setPhone(res.getString(4));
				student.setAge(res.getInt(5));
				
				students.add(student);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return students;
	}
	
	//<============================search by age=================================>
	
	public List<Student> searchByAgeRange(int minAge, int maxAge){
		
		List <Student> students = new ArrayList();
		
		try {
		Connection con = ConnectionFactory.RequestConnection();
		
		String q = "select * from student where age between ? and ?";
		
		PreparedStatement pstmt = con.prepareStatement(q);
		
		pstmt.setInt(1, minAge);
		pstmt.setInt(2, maxAge);
		
		ResultSet res = pstmt.executeQuery();
		
		while(res.next()) {
			Student student = new Student();
			
			student.setStudent_id(res.getInt(1));
			student.setName(res.getString(2));
			student.setEmail(res.getString(3));
			student.setPhone(res.getString(4));
			student.setAge(res.getInt(5));
			
			students.add(student);
		}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		return students;
	}
	
	//<==========================count students==========================>
	
	public int countStudents() {
		try {
			Connection con = ConnectionFactory.RequestConnection();
			
			String q = "select count(*) from student";
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
				return res.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
