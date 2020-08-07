package edu.miu.cs425.webapp.eregistrat;

import edu.miu.cs425.webapp.eregistrat.model.Student;
import edu.miu.cs425.webapp.eregistrat.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class EregistratApplication implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(EregistratApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student robel = new Student("110467", "Robel", "Hailab","Tecleyesus",
                3.5f, LocalDate.of(2019,8,7),"No");
        Student sham = new Student("110468", "Sham", "Kidane","Abraha",
                3.5f, LocalDate.of(2020,8,7),"yes");
        Student henok = new Student("110469", "Henok", "Abraham","Haile",
                3.5f, LocalDate.of(2020,4,7),"No");
        Student luwam = new Student("110465", "Luwam", "Asmerom","Kflit",
                3.5f, LocalDate.of(2021,8,7),"No");
        Student abiel = new Student("110464", "Abiel", "Kidane","Abraha",
                3.5f, LocalDate.of(2019,8,7),"No");

        Student savedRobel = studentService.saveStudent(robel);
        Student savedShame = studentService.saveStudent(sham);
        Student savedHenok = studentService.saveStudent(henok);
        Student savedLuwam = studentService.saveStudent(luwam);
        Student savedAbiel = studentService.saveStudent(abiel);


    }

//    public Student saveStudentMain(Student student){
//        return studentService.saveStudent(student);
//    }
}
