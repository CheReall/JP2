package com.example.JP2.Controllers;

import com.example.JP2.Models.StudentModel;
import com.example.JP2.Models.TeacherModel;
import com.example.JP2.Repo.StudentRepository;
import com.example.JP2.Repo.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class EdRemController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

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
    public String StudentEditShow(@PathVariable(value = "id") long id, Model model){
        if(!studentRepository.existsById(id)){
            return "redirect:/students";
        }
        Optional<StudentModel> studentModel = studentRepository.findById(id);
        ArrayList<StudentModel> editStudent = new ArrayList<>();
        studentModel.ifPresent(editStudent::add);
        model.addAttribute("editStudent", editStudent);
        return "stud/edit-student";
    }
    @GetMapping("/edit-teacher/{id}")
    public String TeacherEditShow(@PathVariable(value = "id") long id, Model model){
        if(!teacherRepository.existsById(id)){
            return "redirect:/teachers";
        }
        Optional<TeacherModel> teacherModel = teacherRepository.findById(id);
        ArrayList<TeacherModel> editTeacher = new ArrayList<>();
        teacherModel.ifPresent(editTeacher::add);
        model.addAttribute("editTeacher", editTeacher);
        return "teach/edit-teacher";
    }

    //Обработка форм редактирования
    @PostMapping("/edit-student/{id}")
    public String StudentEdit(@PathVariable(value = "id") long id, @RequestParam String surname,
                              @RequestParam String name, @RequestParam String middlename, @RequestParam String birthday,
                              @RequestParam String gruppa, @RequestParam Long phone, Model model){
        StudentModel studentModel = studentRepository.findById(id).orElseThrow();
        studentModel.setSurname(name);
        studentModel.setName(surname);
        studentModel.setMiddlename(middlename);
        studentModel.setBirthday(birthday);
        studentModel.setGruppa(gruppa);
        studentModel.setPhone(phone);
        studentRepository.save(studentModel);
        return "redirect:/students";
    }
    @PostMapping("/edit-teacher/{id}")
    public String TeacherEdit(@PathVariable(value = "id") long id, @RequestParam String surname,
                              @RequestParam String name, @RequestParam String middlename,
                              @RequestParam String lessons, @RequestParam String graphic, Model model){
        TeacherModel teacherModel = teacherRepository.findById(id).orElseThrow();
        teacherModel.setSurname(name);
        teacherModel.setName(surname);
        teacherModel.setMiddlename(middlename);
        teacherModel.setLessons(lessons);
        teacherModel.setGraphic(graphic);
        teacherRepository.save(teacherModel);
        return "redirect:/teachers";
    }

    //Обработка удаления
    @PostMapping("/remove-student/{id}")
    public String StudentRemove(@PathVariable(value = "id") long id, Model model){
        StudentModel studentModel = studentRepository.findById(id).orElseThrow();
        studentRepository.delete(studentModel);
        return "redirect:/students";
    }
    @PostMapping("/remove-teacher/{id}")
    public String TeacherRemove(@PathVariable(value = "id") long id, Model model){
        TeacherModel teacherModel = teacherRepository.findById(id).orElseThrow();
        teacherRepository.delete(teacherModel);
        return "redirect:/teachers";
    }
}
