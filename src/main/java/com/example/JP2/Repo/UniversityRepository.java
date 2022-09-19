package com.example.JP2.Repo;

import com.example.JP2.Models.University;
import org.springframework.data.repository.CrudRepository;

public interface UniversityRepository extends CrudRepository<University, Long> {

    University findByNamed(String named);
}