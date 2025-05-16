package com.example.zoo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.zoo.Entities.Animal;
import com.example.zoo.Entities.Enclosure;

public interface EnclosureRepository extends JpaRepository<Enclosure,Long>{
    List<Enclosure>findByID(long id);
}