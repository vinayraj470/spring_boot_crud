package StudentsDump.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import StudentsDump.demo.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	

}
