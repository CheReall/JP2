package com.example.JP2.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class TeacherModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    @NotEmpty(message = "Заполните поле")
    @Size(min = 1, max = 50, message = "От 1 до 50 символов")
    private String surname, name, graphic;
    @Size(max = 50, message = "До 50 символов")
    private String middlename;
    @NotEmpty(message = "Заполните поле")
    @Size(min = 1, max = 250, message = "От 1 до 250 символов")
    private String lessons;
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLessons() {
        return lessons;
    }

    public void setLessons(String lessons) {
        this.lessons = lessons;
    }

    public String getGraphic() {
        return graphic;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public TeacherModel(String surname, String name, String middlename,
                        String lessons, String graphic) {
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
        this.lessons = lessons;
        this.graphic = graphic;
    }

    public TeacherModel() {
    }
}
