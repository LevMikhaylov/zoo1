package com.example.zoo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.zoo.Entities.Animal;
import com.example.zoo.Repositories.AnimalRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
@Service
@Validated
public class AnimalService {
    @Autowired
    private AnimalRepository ar;
    public Animal addAnimal(@NotNull @Valid Animal animal,@RequestParam String name,@RequestParam String kind){
        animal.setName(name);
        animal.setKind(kind);
        ar.save(animal);
        return animal;
    }
    public List<Animal> findAll(){
        return ar.findAll();
    }
    public Animal findByID(@NotNull long id){
        return ar.findByID(id);
    }
    @Transactional
    public Animal updateAnimal(@NotNull long id,@NotNull String name, @NotNull String kind){
        Animal animal = ar.findById(id).orElseThrow(()->new RuntimeException("Animal with id " + id + "not found in database"));
        animal.setName(name);
        animal.setKind(kind);
        return animal;
    }
    public void deleteAnimal(@NotNull long id){
        if(ar.existsById(id)){
            ar.deleteById(id);
        }
        else{
            throw new RuntimeException("Animal with id " + id + "not found in database");
        }

    }
}
