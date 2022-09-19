package com.example.JP2.Models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "grups")
public class Gruppa
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 1, max = 100, message = "От 1 до 50 символов")
    private  String title;
    @ManyToMany (cascade = CascadeType.DETACH)
    @JoinTable (name="student_gruppa",
            joinColumns=@JoinColumn (name="gruppa_id"),
            inverseJoinColumns=@JoinColumn(name="student_id"))
    private List<StudentModel> students;


    public Gruppa(String title, List<StudentModel> students) {
        this.title = title;
        this.students = students;
    }

    public List<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }

    public Gruppa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
















