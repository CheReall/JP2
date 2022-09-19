package com.example.JP2.Repo;

import com.example.JP2.Models.Gruppa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GruppaRepository extends CrudRepository<Gruppa,Long> {

    List<Gruppa> findByTitle(String title);
}
