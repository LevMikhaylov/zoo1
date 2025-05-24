package com.example.zoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.zoo.Entities.Animal;
import com.example.zoo.Services.AnimalService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Controller
@RequestMapping("/animals")
@Validated
public class AnimalController {
    @Autowired
    private AnimalService as;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void addAnimal(@Valid @NotNull Animal animal,@NotNull @RequestParam String name,@NotNull @RequestParam String kind){
        as.addAnimal(animal,name,kind);
    }
    @GetMapping("/allAnimals")
    public String findAll(Model model){
        model.addAttribute("animals",as.findAll());
        return "animals-list";
    }
    @SuppressWarnings("unused")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAnimal(@PathVariable @NotNull long id,@NotNull String name, @NotNull String kind){
       Animal updated = as.updateAnimal(id, name, kind);
       
       return ResponseEntity.ok("Animal updated successfully");
    }
    @DeleteMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable long id){
        as.deleteAnimal(id);
        return "redirect:/animals/allAnimals";
    }
    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("animal",new Animal());
        return "add-animal";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model){
        Animal animal = as.findByID(id);
    model.addAttribute("animal", animal);
    return "edit-animal";
    }
}
