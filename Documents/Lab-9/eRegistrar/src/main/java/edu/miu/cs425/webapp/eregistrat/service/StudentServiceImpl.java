package edu.miu.cs425.webapp.eregistrat.service;

import edu.miu.cs425.webapp.eregistrat.model.Student;
import edu.miu.cs425.webapp.eregistrat.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> fetchStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public void deleteStudentById(Long studentId) {
         studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> searchStudents(String searchString) {
        if(containsDecimalPoint(searchString) && isCGPA(searchString)) {
            return studentRepository.findAllByCgpaEquals(Double.parseDouble(searchString));

        } else if(isDate(searchString)) {
            return studentRepository.findAllByEnrollmentDateEquals(LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE));
        } else {
            return studentRepository.findAllByFirstNameContainingOrLastNameContainingOrStudentNumberContainingOrderByStudentId(searchString, searchString, searchString);
        }
    }
    private boolean isCGPA(String searchString) {
        boolean isParseableAsCGPA = false;
        try {
            Double.parseDouble(searchString);
            isParseableAsCGPA = true;
        } catch(Exception ex) {
            if(ex instanceof ParseException) {
                isParseableAsCGPA = false;
            }
        }
        return isParseableAsCGPA;
    }


    private boolean isDate(String searchString) {
        boolean isParseableAsDate = false;
        try {
            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
            isParseableAsDate = true;
        } catch (Exception ex) {
            if (ex instanceof DateTimeParseException) {
                isParseableAsDate = false;
            }
        }
        return isParseableAsDate;
    }

    private boolean containsDecimalPoint(String searchString) {
        return searchString.contains(".");
    }
}
