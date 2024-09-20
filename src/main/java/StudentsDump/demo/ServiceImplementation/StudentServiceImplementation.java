package StudentsDump.demo.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StudentsDump.demo.Repository.StudentRepository;
import StudentsDump.demo.entities.Student;
import StudentsDump.demo.service.StudentService;

@Service
public class StudentServiceImplementation implements StudentService{
	
	@Autowired
    private StudentRepository studentRepository;
	
	@Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null); 
    }
    
    @Override
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = getStudentById(id);
        if (student != null) {
            student.setFirstName(studentDetails.getFirstName());
            student.setLastName(studentDetails.getLastName());
            student.setEmail(studentDetails.getEmail());
            student.setGpa(studentDetails.getGpa());
            return studentRepository.save(student);
        }
        return null;
    }
    
    @Override
    public String deleteStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.deleteById(id);
            return "Student with ID " + id + " was deleted successfully!";
        } else {
            return "Student with ID " + id + " does not exist!";
        }
    }


}
