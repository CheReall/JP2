package com.example.JP2.Repo;

import com.example.JP2.Models.TeacherModel;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TeacherRepository extends CrudRepository<TeacherModel, Long>{

    List<TeacherModel> findBySurnameContains(String surname);
}
