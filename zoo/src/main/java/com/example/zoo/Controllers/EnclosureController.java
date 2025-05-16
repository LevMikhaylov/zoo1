package com.example.zoo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.example.zoo.Entities.Enclosure;
import com.example.zoo.Services.EnclosureService;

import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/enclosures")
public class EnclosureController {
    @Autowired
    private EnclosureService es;
    @PostMapping("/addEnclosure")
    @ResponseStatus(HttpStatus.OK)
    public void addEnclosure(@NotNull Enclosure enclosure){
        es.addEnclosure(enclosure);
    }
    @GetMapping("/allEnclosures")
    public List<Enclosure> findAll(){
        return es.findAll();
    }
    @GetMapping("/{id}")
    public List<Enclosure> findByID(long id){
        return es.findByID(id);
    }
    @DeleteMapping
    public void deleteEnclusure(long id){
        es.deleteEnclusure(id);
    }
}
