package com.example.zoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.zoo.Entities.Animal;
import com.example.zoo.Services.AnimalService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/animals")
@Validated
public class AnimalController {
    @Autowired
    private AnimalService as;
    @PostMapping("/addedAnimals")
    @ResponseStatus(HttpStatus.OK)
    public void addAnimal(@Valid @NotNull Animal animal){
        as.addAnimal(animal);
    }
    @GetMapping("/allAnimals")
    public void findAll(){
        as.findAll();
    }
    @PutMapping("/updatedAnimals")
    public void updateAnimal(@NotNull long id,@Valid @NotNull Animal animal, @NotNull String name, @NotNull String kind){
        as.updateAnimal(id, animal, name, kind);
    }
    @DeleteMapping
    public void deleteAnimal(long id){
        as.deleteAnimal(id);
    }
}
