package com.example.zoo.Controllers;

import java.util.List;

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

import com.example.zoo.Entities.Guardian;
import com.example.zoo.Services.GuardianService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/guardians")
public class GuardianController {
    @Autowired
    private GuardianService gs;
    @PostMapping("/addedGuardians")
    @ResponseStatus(HttpStatus.OK)
    public void hireGuardian(@Valid Guardian guardian){
        gs.hireGuardian(guardian);
    }
    @GetMapping("/allGuardians")
    public List<Guardian> findaGuardians(){
        return gs.findAll();
    }
    @PutMapping("/updatedGuardians")
    public void updatedGuardian(long id, @Valid Guardian updatedGuardian,String email,String phoneNumber,String name,String surname){
        gs.updateGuardian(id,updatedGuardian,email,phoneNumber,name,surname);
    }
    @DeleteMapping("/deleteGuardian")
    public void fireGuardian(long id){
        gs.fireGuardian(id);
    }
}