package com.example.JP2.Controllers;

import com.example.JP2.Models.StudentModel;
import com.example.JP2.Models.TeacherModel;
import com.example.JP2.Models.University;
import com.example.JP2.Repo.StudentRepository;
import com.example.JP2.Repo.TeacherRepository;
import com.example.JP2.Repo.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class EdRemController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private UniversityRepository universityRepository;

    @GetMapping("/more-student/{id}")
    public String MoreStudent(@PathVariable(value = "id") long id, Model model){
        if(!studentRepository.existsById(id)){
            return "redirect:/students";
        }
        Optional<StudentModel> studentModel = studentRepository.findById(id);
        ArrayList<StudentModel> more = new ArrayList<>();
        studentModel.ifPresent(more::add);
        model.addAttribute("more", more);
        return "stud/more-student";
    }

    // Отображение форм редактирования
    @GetMapping("/edit-student/{id}")
    public String StudentEditShow(@PathVariable("id") long id, Model model){
        StudentModel editStudent = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Неверный ID - "+id));
        model.addAttribute("editStudent", editStudent);
        return "stud/edit-student";
    }
    @GetMapping("/edit-teacher/{id}")
    public String TeacherEditShow(@PathVariable("id") long id, Model model){
        TeacherModel editTeacher = teacherRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Неверный ID - "+id));
        model.addAttribute("editTeacher", editTeacher);
        return "teach/edit-teacher";
    }

    //Обработка форм редактирования
    @PostMapping("/edit-student/{id}")
    public String StudentEdit(@PathVariable("id") long id, @ModelAttribute("studentModel")@Valid StudentModel studentModel, BindingResult bindingResult){
        studentModel.setID(id);
        if(bindingResult.hasErrors()){
            return "/stud/edit-student";
        }
        studentRepository.save(studentModel);
        return "redirect:/students";
    }
    @PostMapping("/edit-teacher/{id}")
    public String TeacherEdit(@PathVariable("id") long id, @ModelAttribute("teacherModel")@Valid TeacherModel teacherModel, BindingResult bindingResult){
        teacherModel.setID(id);
        if(bindingResult.hasErrors()){
            return "teach/edit-teacher";
        }
        teacherRepository.save(teacherModel);
        return "redirect:/teachers";
    }

    //Обработка удаления
    @PostMapping("/remove-student/{id}")
    public String StudentRemove(@PathVariable("id") long id, Model model){
        StudentModel studentModel = studentRepository.findById(id).orElseThrow();
        studentRepository.delete(studentModel);
        return "redirect:/students";
    }
    @PostMapping("/remove-teacher/{id}")
    public String TeacherRemove(@PathVariable("id") long id, Model model){
        TeacherModel teacherModel = teacherRepository.findById(id).orElseThrow();
        teacherRepository.delete(teacherModel);
        return "redirect:/teachers";
    }
}
