package com.example.zoo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import com.example.zoo.Entities.Guardian;
import com.example.zoo.Repositories.GuardianRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
@Validated
public class GuardianService {
    @Autowired
    private GuardianRepository gr;
    public void hireGuardian(@Valid @NotNull Guardian guardian){
        gr.save(guardian);
    }
    public List<Guardian> findAll(){
        return gr.findAll();
    }
    public void updateGuardian(@NotNull long id, @Valid @NotNull Guardian updatedGuardian,@NotNull String email,@NotNull String phoneNumber,@NotNull String name,@NotNull String surname){
        if(gr.existsById(id)){
            updatedGuardian.setEmail(email);
            updatedGuardian.setPhoneNumber(phoneNumber);
            updatedGuardian.setName(name);
            updatedGuardian.setSurname(surname);
            gr.save(updatedGuardian);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Guardian with id " + id + " not found");
        }
    }
        public void fireGuardian(long id) {
        if (!gr.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Guardian with id " + id + " not found");
        }else{
            gr.deleteById(id);
        }
        }
}
