package com.example.zoo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import com.example.zoo.Entities.Guardian;
import com.example.zoo.Repositories.GuardianRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
@Validated
@Transactional
public class GuardianService {
    @Autowired
    private GuardianRepository gr;
    public void hireGuardian(@Valid @NotNull Guardian guardian){
        gr.save(guardian);
    }
    public List<Guardian> findAll(){
        return gr.findAll();
    }
    @Transactional
    public void updateGuardian(@NotNull long id,@NotNull String email,@NotNull String phoneNumber,@NotNull String name,@NotNull String surname){
        Guardian guardian = gr.findById(id) // 1. Загружаем сущность
        .orElseThrow(() -> new RuntimeException("Guardian not found"));
        guardian.setEmail(email);
        guardian.setPhoneNumber(phoneNumber);
        guardian.setName(name);
        guardian.setSurname(surname);
    }
    public void fireGuardian(long id) {
        if (!gr.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Guardian with id " + id + " not found");
        }else{
            gr.deleteById(id);
        }
        
    }
    public Guardian findByID(@NotNull long id){
        return gr.findByID(id);
    }
}
