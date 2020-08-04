package edu.miu.cs.cs425.studenmgmtapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "students")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(name = "student_number", unique = true, nullable = false)
    private String studentNumber;
    @Column(name = "first_name",  nullable = false)
    private String firstName;
    private String middleName;
    @Column(name = "last_name",  nullable = false)
    private String lastName;
    private Double cgpa;
    @Column(name="admission_date")
    private LocalDate dateOfEnrollement;

    @OneToOne
    @JoinColumn(name = "transcript_id", nullable = false, unique = true)
    private Transcript transcript;

    @ManyToOne
    @JoinColumn( name = "classroom_id" , nullable = true)
    private ClassRoom classroom;

    public Student( Long studentId, String studentNumber, String firstName, String middleName, String lastName, Double cgpa, LocalDate dateOfEnrollement,ClassRoom classroom) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollement = dateOfEnrollement;

    }

    public Student( String studentNumber, String firstName, String middleName,  String lastName,
                   Double cgpa, LocalDate dateOfEnrollement, Transcript transcript, ClassRoom classroom) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollement = dateOfEnrollement;
        this.transcript = transcript;
        this.classroom = classroom;

    }

    public Student() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getDateOfEnrollement() {
        return dateOfEnrollement;
    }

    public void setDateOfEnrollement(LocalDate dateOfEnrollement) {
        this.dateOfEnrollement = dateOfEnrollement;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public ClassRoom getClassroom() {
        return classroom;
    }

    public void setClassroom(ClassRoom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cgpa=" + cgpa +
                ", dateOfEnrollement=" + dateOfEnrollement +
                ", transcript=" + transcript +
                ", classroom=" + classroom +
                '}';
    }
}
