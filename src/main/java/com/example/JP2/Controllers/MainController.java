package com.example.JP2.Controllers;

import com.example.JP2.Models.StudentModel;
import com.example.JP2.Models.TeacherModel;
import com.example.JP2.Repo.StudentRepository;
import com.example.JP2.Repo.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;

//     Отображение главных страниц
    @GetMapping("/")
    public String Welcome(Model model){
        return "homePage";
    }
    @GetMapping("/students")
    public String Students(Model model){
        Iterable<StudentModel> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "stud/students";
    }
    @GetMapping("/teachers")
    public String Teachers(Model model){
        Iterable<TeacherModel> teachers = teacherRepository.findAll();
        model.addAttribute("teachers", teachers);
        return "teach/teachers";
    }

    // Отображение форм добавления записи
    @GetMapping("/add-student")
    public String AddStudent(StudentModel studentModel){
        return "stud/add-student";
    }
    @GetMapping("/add-teacher")
    public String AddTeacher(TeacherModel teacherModel){
        return "teach/add-teacher";
    }

    //    Обработка форм добавления студентов и преподавателей
    @PostMapping("/student-save")
    public String SaveStudent(@ModelAttribute("studentModel")@Valid StudentModel studentModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "stud/add-student";
        }
        studentRepository.save(studentModel);
        return "redirect:/students";
    }
    @PostMapping("/teacher-save")
    public String SaveTeacher(@ModelAttribute("teacherModel")@Valid TeacherModel teacherModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "teach/add-teacher";
        }
        teacherRepository.save(teacherModel);
        return "redirect:/teachers";
    }

    // Отображение страниц поиска студентов и преподавателей
    @GetMapping("/students-search")
    public String SearchS(){
        return "stud/search-students";
    }
    @GetMapping("/teachers-search")
    public String SearchT(){
        return "teach/search-theachers";
    }

    // Обработка форм поиска студентов и преподавателей
    @PostMapping("/students-search-process")
    public String SearchStudent (@RequestParam String surname, Model model){
        List<StudentModel> result = studentRepository.findBySurnameContains(surname);
        model.addAttribute("result", result);
        return "stud/search-students";
    }
    @PostMapping("/teachers-search-process")
    public String SearchTeacher (@RequestParam String surname, Model model){
        List<TeacherModel> result = teacherRepository.findBySurnameContains(surname);
        model.addAttribute("result", result);
        return "teach/search-theachers";
    }
}

