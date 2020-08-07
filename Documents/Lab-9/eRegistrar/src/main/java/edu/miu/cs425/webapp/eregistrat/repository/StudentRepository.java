package edu.miu.cs425.webapp.eregistrat.repository;

import edu.miu.cs425.webapp.eregistrat.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllByFirstNameContainingOrLastNameContainingOrStudentNumberContainingOrderByStudentId(String firstName,
                                                                                                            String lastName,
                                                                                                            String studentNumber);
    List<Student> findAllByEnrollmentDateEquals(LocalDate enrollmentdate);
    List<Student> findAllByCgpaEquals(Double cGpa);

    // More queries
    List<Student> findBooksByEnrollmentDateIsStartingWith(String str);
}
