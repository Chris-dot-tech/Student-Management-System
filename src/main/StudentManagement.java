

	package main;

	import java.util.List;
	import java.util.Scanner;

	import DAO.StudentDAO;
	import DAO.CourseDAO;

	import DAOImpl.StudentDAOImpl;
	import DAOImpl.CourseDAOImpl;

	import DTO.Student;
	import DTO.Course;

	public class StudentManagement {

		public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);

			StudentDAO studentDAO = new StudentDAOImpl();
			CourseDAO courseDAO = new CourseDAOImpl();

			int choice;

			do {

				System.out.println("========================================");
				System.out.println("       STUDENT MANAGEMENT SYSTEM");
				System.out.println("========================================");

				System.out.println("----------- STUDENT -----------");
				System.out.println("1. Add Student");
				System.out.println("2. View All Students");
				System.out.println("3. Find Student By ID");
				System.out.println("4. Update Student");
				System.out.println("5. Delete Student");
				System.out.println("6. Search Student By Name");
				System.out.println("7. Search Student By Age");

				System.out.println("\n----------- COURSE ------------");
				System.out.println("8. Add Course");
				System.out.println("9. View All Courses");
				System.out.println("10. Find Course By ID");
				System.out.println("11. Update Course");
				System.out.println("12. Delete Course");
				System.out.println("13. Search Course By Name");
				System.out.println("14. Search Course By Fee");

				System.out.println("\n<----------- REPORT ------------>");
				System.out.println("15. Count Students");
				System.out.println("16. Count Courses");

				System.out.println("0. Exit");

				System.out.print("\nEnter your choice: ");
				choice = sc.nextInt();
				

				switch (choice) {

				// ================= ADD STUDENT =================

				case 1:

					System.out.println("Enter Student Name: ");
					String name = sc.next();

					System.out.println("Enter Email: ");
					String email = sc.next();

					System.out.println("Enter Phone: ");
					String phone = sc.next();

					System.out.println("Enter Age: ");
					int age = sc.nextInt();
					

					Student student = new Student();

					student.setName(name);
					student.setEmail(email);
					student.setPhone(phone);
					student.setAge(age);

					studentDAO.addStudent(student);

					System.out.println("Student Added Successfully");

					break;


				// ================= VIEW ALL STUDENTS =================

				case 2:

					List<Student> students = studentDAO.getAllStudent();

					for (Student s : students) {

						System.out.println(
								s.getStudent_id() + 
								" | "+ s.getName() + 
								" | "+ s.getEmail() + 
								" | "+ s.getPhone() + 
								" | "+ s.getAge());
					}

					break;


				// ================= FIND STUDENT =================

				case 3:

					System.out.print("Enter Student ID: ");
					int studentId = sc.nextInt();
					

					Student findStudent =
							studentDAO.getStudentById(studentId);

					if (findStudent != null) {

						System.out.println("Student ID : "
								+ findStudent.getStudent_id());

						System.out.println("Name       : "
								+ findStudent.getName());

						System.out.println("Email      : "
								+ findStudent.getEmail());

						System.out.println("Phone      : "
								+ findStudent.getPhone());

						System.out.println("Age        : "
								+ findStudent.getAge());

					} else {

						System.out.println("Student Not Found");

					}

					break;


				// ================= UPDATE STUDENT =================

				case 4:

					System.out.print("Enter Student ID: ");
					int updateId = sc.nextInt();
					sc.nextLine();

					System.out.print("Enter New Name: ");
					String newName = sc.nextLine();

					System.out.print("Enter New Email: ");
					String newEmail = sc.nextLine();

					System.out.print("Enter New Phone: ");
					String newPhone = sc.nextLine();

					System.out.print("Enter New Age: ");
					int newAge = sc.nextInt();
					

					Student updateStudent = new Student();

					updateStudent.setStudent_id(updateId);
					updateStudent.setName(newName);
					updateStudent.setEmail(newEmail);
					updateStudent.setPhone(newPhone);
					updateStudent.setAge(newAge);

					studentDAO.updateStudent(updateStudent);

					System.out.println("Student Updated Successfully");

					break;


				// ================= DELETE STUDENT =================

				case 5:

					System.out.print("Enter Student ID: ");
					int deleteId = sc.nextInt();
					

					studentDAO.deleteStudent(deleteId);

					System.out.println("Student Deleted Successfully");

					break;


				// ================= SEARCH STUDENT NAME =================

				case 6:

					System.out.print("Enter Student Name: ");
					String searchName = sc.nextLine();

					List<Student> nameList =
							studentDAO.searchByName(searchName);

					for (Student s : nameList) {

						System.out.println(
								s.getStudent_id() + " | "
								+ s.getName() + " | "
								+ s.getEmail() + " | "
								+ s.getPhone() + " | "
								+ s.getAge()
						);
					}

					break;


				// ================= SEARCH STUDENT AGE =================

				case 7:

					System.out.print("Enter Minimum Age: ");
					int minAge = sc.nextInt();

					System.out.print("Enter Maximum Age: ");
					int maxAge = sc.nextInt();
					sc.nextLine();

					List<Student> ageList =
							studentDAO.searchByAgeRange(minAge, maxAge);

					for (Student s : ageList) {

						System.out.println(
								s.getStudent_id() + " | "
								+ s.getName() + " | "
								+ s.getAge()
						);
					}

					break;


				// ================= ADD COURSE =================

				case 8:

					System.out.print("Enter Course Name: ");
					String courseName = sc.nextLine();

					System.out.print("Enter Duration: ");
					String duration = sc.nextLine();

					System.out.print("Enter Fees: ");
					double fees = sc.nextDouble();
					sc.nextLine();

					Course course = new Course();

					course.setCourse_name(courseName);
					course.setDuration(duration);
					course.setFees(fees);

					courseDAO.addCourse(course);

					System.out.println("Course Added Successfully");

					break;


				// ================= VIEW ALL COURSES =================

				case 9:

					List<Course> courses = courseDAO.getAllCourse();

					for (Course c : courses) {

						System.out.println(
								c.getCourse_id() + " | "
								+ c.getCourse_name() + " | "
								+ c.getDuration() + " | "
								+ c.getFees()
						);
					}

					break;


				// ================= FIND COURSE =================

				case 10:

					System.out.print("Enter Course ID: ");
					int courseId = sc.nextInt();
					sc.nextLine();

					Course findCourse =
							courseDAO.getCourseById(courseId);

					if (findCourse != null) {

						System.out.println("Course ID   : "
								+ findCourse.getCourse_id());

						System.out.println("Course Name : "
								+ findCourse.getCourse_name());

						System.out.println("Duration    : "
								+ findCourse.getDuration());

						System.out.println("Fees        : "
								+ findCourse.getFees());

					} else {

						System.out.println("Course Not Found");

					}

					break;


				// ================= UPDATE COURSE =================

				case 11:

					System.out.print("Enter Course ID: ");
					int updateCourseId = sc.nextInt();
					sc.nextLine();

					System.out.print("Enter New Course Name: ");
					String newCourseName = sc.nextLine();

					System.out.print("Enter New Duration: ");
					String newDuration = sc.nextLine();

					System.out.print("Enter New Fees: ");
					double newFees = sc.nextDouble();
					sc.nextLine();

					Course updateCourse = new Course();

					updateCourse.setCourse_id(updateCourseId);
					updateCourse.setCourse_name(newCourseName);
					updateCourse.setDuration(newDuration);
					updateCourse.setFees(newFees);

					courseDAO.updateCourse(updateCourse);

					System.out.println("Course Updated Successfully");

					break;


				// ================= DELETE COURSE =================

				case 12:

					System.out.print("Enter Course ID: ");
					int deleteCourseId = sc.nextInt();
					sc.nextLine();

					courseDAO.deleteCourse(deleteCourseId);

					System.out.println("Course Deleted Successfully");

					break;


				// ================= SEARCH COURSE NAME =================

				case 13:

					System.out.print("Enter Course Name: ");
					String searchCourseName = sc.nextLine();

					List<Course> courseNameList =
							courseDAO.searchByName(searchCourseName);

					for (Course c : courseNameList) {

						System.out.println(
								c.getCourse_id() + " | "
								+ c.getCourse_name() + " | "
								+ c.getDuration() + " | "
								+ c.getFees()
						);
					}

					break;


				// ================= SEARCH COURSE FEE =================

				case 14:

					System.out.print("Enter Minimum Fee: ");
					double minFee = sc.nextDouble();

					System.out.print("Enter Maximum Fee: ");
					double maxFee = sc.nextDouble();
					sc.nextLine();

					List<Course> feeList =courseDAO.searchByFeeRange(minFee, maxFee);

					for (Course c : feeList) {

						System.out.println(
								c.getCourse_id() + " | "
								+ c.getCourse_name() + " | "
								+ c.getFees()
						);
					}

					break;


				// ================= COUNT STUDENTS =================

				case 15:

					int studentCount =
							studentDAO.countStudents();

					System.out.println(
							"Total Students: " + studentCount
					);

					break;


				// ================= COUNT COURSES =================

				case 16:

					int courseCount =
							courseDAO.countCourses();

					System.out.println(
							"Total Courses: " + courseCount
					);

					break;


				// ================= EXIT =================

				case 0:

					System.out.println("Thank You! For Using Student management System 🙌");
					break;


				default:

					System.out.println("Invalid Choice 😒");

				}

			} while (choice != 0);

			sc.close();
		}
	}

