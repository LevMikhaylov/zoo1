package com.example.zoo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.zoo.Entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal,Long>{
    
}
