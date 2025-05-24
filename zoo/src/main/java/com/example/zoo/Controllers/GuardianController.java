package com.example.zoo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.zoo.Entities.Guardian;
import com.example.zoo.Services.GuardianService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping("/guardians")
@Validated
public class GuardianController {
    
    @Autowired
    private GuardianService gs;

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("guardian", new Guardian());
        return "add-guardian";
    }

    @PostMapping("/add")
    public String hireGuardian(@Valid @ModelAttribute Guardian guardian) {
        gs.hireGuardian(guardian);
        return "redirect:/guardians/all";
    }

    @GetMapping("/all")
    public String findAllGuardians(Model model) {
        List<Guardian> guardians = gs.findAll();
        model.addAttribute("guardians", guardians);
        return "guardians-list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Guardian guardian = gs.findByID(id);
        model.addAttribute("guardian", guardian);
        return "edit-guardian";
    }

    @PostMapping("/update/{id}")
    public String updateGuardian(@PathVariable long id,
                               @RequestParam String email,
                               @RequestParam String phoneNumber,
                               @RequestParam String name,
                               @RequestParam String surname) {
        gs.updateGuardian(id, email, phoneNumber, name, surname);
        return "redirect:/guardians/all";
    }

    @GetMapping("/delete/{id}")
    public String fireGuardian(@PathVariable long id) {
        gs.fireGuardian(id);
        return "redirect:/guardians/all";
    }
}