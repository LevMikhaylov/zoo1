package com.example.zoo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import com.example.zoo.Entities.Animal;
import com.example.zoo.Repositories.AnimalRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
@Validated
public class AnimalService {
    @Autowired
    private AnimalRepository ar;
    public void addAnimal(@NotNull @Valid Animal animal){
        ar.save(animal);
    }
    public void findAll(){
        ar.findAll();
    }
    public void updateAnimal(@NotNull long id,@NotNull @Valid Animal animal,@NotNull String name, @NotNull String kind){
        if(ar.existsById(id)){
            animal.setName(name);
            animal.setKind(kind);
            ar.save(animal);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Animal with id " + id + " not found");
        }
    }
    public void deleteAnimal(@NotNull long id){
        if(ar.existsById(id)){
            ar.deleteById(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Animal with id " + id + " not found");
        }
    }
}
