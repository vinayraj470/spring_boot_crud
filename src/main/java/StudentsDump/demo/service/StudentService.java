package StudentsDump.demo.service;

import java.util.List;


import StudentsDump.demo.entities.Student;

public interface StudentService {
	
    Student saveStudent(Student student); // service to save students in the database 
    
    List<Student> getAllStudents(); // service for getting list of students
    
    Student getStudentById(Long id); // service to get student by id
    
    Student updateStudent(Long id, Student student);  // service to update the existing student data
    
    String deleteStudent(Long id); // service to delete the student in the databasee
}

