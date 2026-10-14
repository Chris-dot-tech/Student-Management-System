package DTO;

public class Student {

	private int student_id;
	private String name;
	private String email;
	private String phone;
	private int age;
	
	Student(int student_id, String name, String email, String phone, int age){
		
		this.student_id = student_id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.age = age;
		
		}

	public Student() {
		
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student[student_id = " + student_id + " , name = " + name + " , email = " + email + " , phone = " + phone + ", age = " + age + "]";
	}
}
