package com.example.JP2.Repo;

import com.example.JP2.Models.Adress;
import org.springframework.data.repository.CrudRepository;

public interface AdressRepository extends CrudRepository<Adress, Long> {
    Adress findByAdres(String adres);
}