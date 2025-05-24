package com.example.zoo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.zoo.Entities.Animal;

import jakarta.validation.constraints.NotNull;

public interface AnimalRepository extends JpaRepository<Animal,Long>{
    Animal findByID(@NotNull long id);
}
