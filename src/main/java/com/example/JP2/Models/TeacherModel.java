package com.example.JP2.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TeacherModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private String surname, name, middlename, lessons, graphic;

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
