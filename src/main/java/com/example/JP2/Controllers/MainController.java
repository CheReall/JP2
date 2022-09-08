package com.example.JP2.Controllers;

import com.example.JP2.Models.StudentModel;
import com.example.JP2.Models.TeacherModel;
import com.example.JP2.Repo.StudentRepository;
import com.example.JP2.Repo.TeacherRepository;
import com.sun.xml.bind.api.Bridge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;

    // Отображение главных страниц
    @GetMapping("/")
    public String Home(Model model){
        return "homePage";
    }
    @GetMapping("/teachers")
    public String Teachers(Model model){
        Iterable<TeacherModel> teachers = teacherRepository.findAll();
        model.addAttribute("teachers", teachers);
        return "teachers";
    }
    @GetMapping("/students")
    public String Students(Model model){
        Iterable<StudentModel> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "students";
    }

    // Отображение форм добавления записи
    @GetMapping("/add-teacher")
    public String AddTeacher(Model model){
        return "add-teacher";
    }
    @GetMapping("/add-student")
    public String AddStudent(Model model){
        return "add-student";
    }

    //    Обработка форм добавления студентов и преподавателей
    @PostMapping("/student-save")
    public String SaveStudent(@RequestParam String surname, @RequestParam String name,
                              @RequestParam String middlename, @RequestParam String birthday,
                              @RequestParam String gruppa, @RequestParam Long phone, Model model){
        StudentModel student = new StudentModel(surname, name, middlename, birthday, gruppa, phone);
        studentRepository.save(student);
        return "redirect:/students";
    }
    @PostMapping("/teacher-save")
    public String SaveTeacher(@RequestParam String surname, @RequestParam String name,
                              @RequestParam String middlename, @RequestParam String lessons,
                              @RequestParam String graphic, Model model){
        TeacherModel teacher = new TeacherModel(surname, name, middlename, lessons, graphic);
        teacherRepository.save(teacher);
        return "redirect:/teachers";
    }

    // Отображение страниц поиска студентов и преподавателей
    @GetMapping("/students-search")
    public String SearchS(){
        return "students-search";
    }
    @GetMapping("/teachers-search")
    public String SearchT(){
        return "teachers-search";
    }

    // Обработка форм поиска студентов и преподавателей
    @PostMapping("/students-search-process")
    public String SearchStudent (@RequestParam String surname, Model model){
        List<StudentModel> result = studentRepository.findBySurnameContains(surname);
        model.addAttribute("result", result);
        return "students-search";
    }
    @PostMapping("/teachers-search-process")
    public String SearchTeacher (@RequestParam String surname, Model model){
        List<TeacherModel> result = teacherRepository.findBySurname(surname);
        model.addAttribute("result", result);
        return "teachers-search";
    }
}
