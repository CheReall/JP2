package com.example.JP2.Models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Заполните поле")
    @Size(min = 1, max = 50, message = "От 1 до 50 символов")
    private String surname, name, birthday;

    @Size(max = 10, message = "Максимум 10 символов")
    private String gruppa;
    @Size(max = 50, message = "Максимум 50 символов")
    private String middlename;
    @NotEmpty(message = "Заполните поле")
    @Size(min = 16, max = 16, message = "Не соответствуие формату +7(___)___-__-__")
    private String phone;
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable (name="student_gruppa",
            joinColumns=@JoinColumn (name="student_id"),
            inverseJoinColumns=@JoinColumn(name="gruppa_id"))
    private List<Gruppa> gruppas;
    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private University universitys;
    public University getUniversitys() {
        return universitys;
    }
    public void setUniversitys(University universitys) {
        this.universitys = universitys;
    }
    public List<Gruppa> getGruppas() {
        return gruppas;
    }
    public void setGruppas(List<Gruppa> gruppas) {
        this.gruppas = gruppas;
    }
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public StudentModel(String surname, String name, String middlename,
                        String birthday, String gruppa, String phone) {
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
