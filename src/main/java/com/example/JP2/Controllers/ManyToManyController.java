package com.example.JP2.Controllers;

import com.example.JP2.Models.Gruppa;
import com.example.JP2.Models.StudentModel;
import com.example.JP2.Repo.GruppaRepository;
import com.example.JP2.Repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManyToManyController
{
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GruppaRepository gruppaRepository;

    @GetMapping("/grupps")
    private String Grupps(Model model){
        Iterable<StudentModel> students = studentRepository.findAll();
        model.addAttribute("students", students);
        Iterable<Gruppa> gruppa = gruppaRepository.findAll();
        model.addAttribute("gruppa", gruppa);
        return "other/grupps";
    }
    @PostMapping("/grupps/add")
    public String GruppaAdd(@RequestParam Long student, @RequestParam Long gruppas, Model model)
    {
        StudentModel studentModel = studentRepository.findById(student).orElseThrow();
        Gruppa gruppa = gruppaRepository.findById(gruppas).orElseThrow();
        studentModel.getGruppas().add(gruppa);
        gruppa.getStudents().add(studentModel);
        studentRepository.save(studentModel);
        gruppaRepository.save(gruppa);
        return "redirect:/grupps";
    }
    @GetMapping("/grupps/add")
    public String gruppsAdd(Model model){
        Iterable<Gruppa> gruppa = gruppaRepository.findAll();
        model.addAttribute("gruppa", gruppa);
        Iterable<StudentModel> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "other/grupa-add";
    }
    @PostMapping("/grupps/{id}/remove")
    public String GruppaDelete(@PathVariable("id") long id, Model model){
        Gruppa gruppa = gruppaRepository.findById(id).orElseThrow();
        gruppaRepository.delete(gruppa);
        return "redirect:/grupps";
    }
}
