package edu.miu.cs425.webapp.eregistrat.service;

import edu.miu.cs425.webapp.eregistrat.model.Student;
import edu.miu.cs425.webapp.eregistrat.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public abstract List<Student> fetchStudents();
    public abstract Student saveStudent(Student student);
    public abstract Student getStudentById(Long studentId);
    public abstract void deleteStudentById(Long studentId);
    public abstract List<Student> searchStudents(String searchString);
}
