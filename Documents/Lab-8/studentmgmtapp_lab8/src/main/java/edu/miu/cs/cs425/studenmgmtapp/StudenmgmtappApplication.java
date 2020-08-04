package edu.miu.cs.cs425.studenmgmtapp;

import edu.miu.cs.cs425.studenmgmtapp.model.ClassRoom;
import edu.miu.cs.cs425.studenmgmtapp.model.Student;
import edu.miu.cs.cs425.studenmgmtapp.model.Transcript;
import edu.miu.cs.cs425.studenmgmtapp.repository.ClassRoomRepository;
import edu.miu.cs.cs425.studenmgmtapp.repository.StudentRepository;
import edu.miu.cs.cs425.studenmgmtapp.repository.TranscriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;


@SpringBootApplication
public class StudenmgmtappApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TranscriptRepository transcriptRepository;
    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Autowired
    public StudenmgmtappApplication(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(StudenmgmtappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //2 new class rooms
        ClassRoom cr1 = new ClassRoom("Verrile Hall", "V29");
        ClassRoom savedcr1 = classRoomRepository.save(cr1);
        ClassRoom cr2 = new ClassRoom("Mclaughing", "105");
        ClassRoom savedcr2 = classRoomRepository.save(cr2);


//        cr1.setStudents();

        // 4 different new Transcripts
        Transcript tr1 = new Transcript("Computer Science");
        Transcript savedtr1 = transcriptRepository.save(tr1);
        Transcript tr2 = new Transcript("MA Pharmacy");
        Transcript savedtr2 = transcriptRepository.save(tr2);
        Transcript tr3 = new Transcript("BS Politcs");
        Transcript savedtr3 = transcriptRepository.save(tr3);
        Transcript tr4 = new Transcript("PhD Vedic Science");
        Transcript savedtr4 = transcriptRepository.save(tr4);


        //4 new Students
        Student st1 = new Student("000-61-0001","Robel","Hailab","Tecleyesus",3.89, LocalDate.of(2019,8,8),tr1,cr1);
        Student savedst1 = studentRepository.save(st1);
        Student st2 = new Student("111-61-0002","Luwam","Asmerom","Kiflit",4.00, LocalDate.of(2020,3,4),tr2, cr1);
        Student savedst2 = studentRepository.save(st2);
        Student st3 = new Student("222-61-0002","Sham","Kidane","Abraha",3.60, LocalDate.of(2020,8,8),tr3, cr2);
        Student savedst3 = studentRepository.save(st3);
        Student st4 = new Student("333-61-0002","Henok","Abraham","Haile",3.89, LocalDate.of(2020,8,8),tr4, cr2);
        Student savedst4 = studentRepository.save(st4);


        tr1.setStudent(st1);
        tr2.setStudent(st2);
        tr3.setStudent(st3);
        tr4.setStudent(st4);

        System.out.println(savedst1);
        System.out.println(savedst2);
        System.out.println(savedst3);
        System.out.println(savedst4);

        System.out.println(savedtr1);
        System.out.println(savedtr2);
        System.out.println(savedtr3);
        System.out.println(savedtr4);

        System.out.println(savedcr1);
        System.out.println(savedcr2);

        showListOfStudents().forEach(System.out::print);
        showListOfClasses().forEach(System.out::print);
        showListOfTranscripts().forEach(System.out::print);




//        Student student1 = new Student("000-61-0001","Anna","Lynn","Smith",3.45, LocalDate.of(2019,5,24));
//        Student saveStudent1 = studentRepository.save(student1);
//        showListOfStudents().forEach(System.out::print);


    }

    private Iterable<Student> showListOfStudents(){
        return studentRepository.findAll();
    }

    private Iterable<ClassRoom> showListOfClasses(){
        return classRoomRepository.findAll();
    }

    private Iterable<Transcript> showListOfTranscripts(){
        return transcriptRepository.findAll();
    }
}
