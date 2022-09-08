package com.example.JP2.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
@Entity
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String surname, name, middlename, gruppa, birthday;
    private Long phone;

    public Long getID() {
        return id;
    }

    public void setID(Long ID) {
        this.id = id;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getGruppa() {
        return gruppa;
    }

    public void setGruppa(String gruppa) {
        this.gruppa = gruppa;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public StudentModel(String surname, String name, String middlename,
                        String birthday, String gruppa, Long phone) {
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
        this.birthday = birthday;
        this.gruppa = gruppa;
        this.phone = phone;
    }
    public StudentModel() {
    }
}
