package com.example.JP2.Repo;

import com.example.JP2.Models.StudentModel;
import com.example.JP2.Models.TeacherModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<StudentModel, Long> {

    List<StudentModel> findBySurnameContains(String surname);
}
