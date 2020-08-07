package edu.miu.cs425.webapp.eregistrat.controller;

import edu.miu.cs425.webapp.eregistrat.model.Student;
import edu.miu.cs425.webapp.eregistrat.service.StudentService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.directory.SearchResult;
import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/student/list")
    public ModelAndView listStudents(){
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.fetchStudents();
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", "");
        modelAndView.addObject("studentCount",students.size());
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

    @GetMapping(value = "/student/new")
    public String displayAddNewBookForm(Model model){
        model.addAttribute("student", new Student());
        return "student/new";
    }

    @PostMapping(value = {"/eregistrar/student/new","/student/new"})
        public String addNewStudent(@Valid @ModelAttribute("student" )Student student, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {//to show the error message for the user
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/new";
        }
        student = studentService.saveStudent(student);
        return "redirect:/student/list";
    }
    @GetMapping(value = {"/eregistrar/student/edit/{StudentId}","/student/edit/{studentId}"})
    public String editStudent(@PathVariable Long studentId, Model model){
        Student student = studentService.getStudentById(studentId);
        if(student!= null){
            model.addAttribute("student",student);
            return "student/edit";
        }
        return "student/list";
    }
    @PostMapping(value = {"eregistrar/student/edit","student/edit"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                                 BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        student = studentService.saveStudent(student);
        return "redirect:/student/list";
    }

    @GetMapping(value = {"/student/delete/{studentId}", "student/delete"})
    public String deleteBook(@PathVariable Long studentId, Model model){
        studentService.deleteStudentById(studentId);
        return "redirect:/student/list";
    }
    @GetMapping(value = {"/eregistrar/student/search", "/book/search"})
    public ModelAndView searchStudents(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.searchStudents(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("studentsCount", students.size());
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

}
